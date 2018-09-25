package linqh.test.demo1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ConverterConfig {

    @Value("${spring.jackson.date-format}")
    private String datePattern;

    /**
     * 前台日期字符串转换成java对象Date
     */
    @Component
    public class String2DateConverter implements Converter<String, Date>{

        @Override
        public Date convert(String dateStr) {
            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                throw new RuntimeException("日期转换出错!",e);
            }
        }
    }

}
