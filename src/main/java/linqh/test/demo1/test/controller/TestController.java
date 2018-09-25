package linqh.test.demo1.test.controller;

import linqh.test.demo1.test.mapper.AlarmInfoCfgMapper;
import linqh.test.demo1.test.mapper.LabelMapper;
import linqh.test.demo1.test.model.AlarmInfoCfg;
import linqh.test.demo1.test.model.Label;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private AlarmInfoCfgMapper alarmInfoCfgMapper;
    @Autowired
    private LabelMapper labelMapper;

    @GetMapping("print")
    public void print(){
        System.out.println("test");
    }

    @GetMapping("sql/xml")
    public List<AlarmInfoCfg> listByXML(){
        return alarmInfoCfgMapper.listByXML();
    }

    @GetMapping("sql/annotation")
    public List<AlarmInfoCfg> listByAnnotation(){
        return alarmInfoCfgMapper.listByAnnotation();
    }

    @GetMapping("sql/basemapper")
    public List<AlarmInfoCfg> listByBaserMapper(){
        return alarmInfoCfgMapper.selectByMap(new HashMap<String,Object>());
    }

    @Value("${server.servlet.context-path}")
    String contextPath;

    /**
     * 测试日期序列化
     * @return
     */
    @GetMapping("getDate")
    public Date getDate(){
        return new Date();
    }

    /**
     * 测试日期反序列化
     * @param date
     */
    @GetMapping("receivedDate")
    public void receivedDate(Date date){
        System.out.println(new SimpleDateFormat().format(date));
    }

    @GetMapping("getString")
    public StringHolder getString(){
        return new StringHolder("linqh","1234567890987654321");
    }

    @GetMapping("getLong")
    public LongHolder getLong(){
        return new LongHolder("linqh",1234567890987654321l);
    }

    @GetMapping("getChinese")
    public String getChinese(){
        return "中文";
    }

    @GetMapping("receiveChinese")
    public void receiveChinese(String value){
        System.out.println(value);
    }

    @GetMapping("index")
    public ModelAndView index(){
        return new ModelAndView("test/index");
    }

    //如果没写getter的话，貌似类无法序列化成字符串
    public class LongHolder {
        public LongHolder(String key, Long value){
            this.key = key;
            this.value = value;
        }
        //在未做相关配置的情况下:
        //如果类型是Long的话,序列化成字符串的时候,格式如:{"value":"1234567890987654321","key":"linqh"}
        //如果类型是long的话,序列化成字符串的时候,格式如:{"value":1234567890987654321,"key":"linqh"}
        long value;
        String key;

        public long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public class StringHolder {
        public StringHolder(String key, String value){
            this.key = key;
            this.value = value;
        }
        String key;
        String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    @GetMapping("error")
    public String error(){
        int i = 1/0;
        return "can not reach";
    }

    @PostMapping("status-201")
    @ResponseStatus(HttpStatus.CREATED)
    public String status(HttpServletRequest request,HttpServletResponse response){
        System.out.println(request.getContextPath());
        System.out.println(contextPath);
        response.setHeader("Location",contextPath+"/test/sql/xml");
        return contextPath+"/test/sql/xml";
    }

    @GetMapping("responseentity")
    public ResponseEntity<Map<String,String>> getResponseEntity(){
        Map<String,String> map = new HashMap<>();
        map.put("name","linqh");
        map.put("age","18");
        MultiValueMap<String,String> headerMap = new HttpHeaders();
        headerMap.add("Location",contextPath + "/test/sql/xml");
        return new ResponseEntity<Map<String,String>>(map,headerMap,HttpStatus.CREATED);
    }

    @GetMapping("local/label")
    public List<Label> queryDB(){
        return labelMapper.all();
    }

    @GetMapping("validate")
    public void validate(@Valid SimpleModel simpleModel, BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return;
        }
        System.out.println("validate sucess");
    }

    @GetMapping("getrequest")
    public void getrequest(HttpServletRequest request,HttpServletResponse response){
        System.out.println("validate sucess");
    }

    public static class SimpleModel {
        @NotBlank(message = "名称不能为空")
        private String name;

        @Range(min = 18,message = "必须大于18岁")
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
