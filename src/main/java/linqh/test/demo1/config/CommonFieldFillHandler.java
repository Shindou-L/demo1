package linqh.test.demo1.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import linqh.test.demo1.test.model.CommonField;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class CommonFieldFillHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("trigger insertFill");
//        Object object = metaObject.getOriginalObject();//有时候不是对象本身
//        if(object instanceof CommonField){
//            CommonField field = (CommonField) object;
//            field.setCreateUser("admin");
//            field.setCreateTime(new Date());
//            field.setUpdateUser("admin");
//            field.setUpdateTime(new Date());
//        }
        setFieldValByName("createUser","admin", metaObject);
        setFieldValByName("createTime",new Date(), metaObject);
        setFieldValByName("updateUser","admin", metaObject);
        setFieldValByName("updateTime",new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("trigger updateFill");
//        Object object = metaObject.getOriginalObject();
//        if(object instanceof CommonField){
//            CommonField field = (CommonField) object;
//            field.setUpdateUser("admin");
//            field.setUpdateTime(new Date());
//        }
        setFieldValByName("updateUser","admin", metaObject);
        setFieldValByName("updateTime",new Date(), metaObject);
    }
}
