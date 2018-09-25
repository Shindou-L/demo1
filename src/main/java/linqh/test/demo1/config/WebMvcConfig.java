package linqh.test.demo1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig {

    /**
     * 再未配置此项的时候：
     *   如果类型是Long的话,序列化成字符串的时候,格式如:{"value":"1234567890987654321","key":"linqh"}
     *   如果类型是long的话,序列化成字符串的时候,格式如:{"value":1234567890987654321,"key":"linqh"}
     *
     * 配置此项的时候，也可以采用@EnableWebMvc + class myclass extends WebMvcConfigurationAdapter.但是这种方法会覆盖一些默认配置（如视图配置等），需要自己重新配置，比较麻烦
     * 所以采用另一种方式进行配置
     */
    @Bean
    public HttpMessageConverter getLongSerializationConverter() {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return jackson2HttpMessageConverter;
    }
}
