package linqh.test.demo1;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

    @Autowired
    GeneratorConfig generatorConfig;

    @Test
    public void contextLoads() {
        generator(generatorConfig);
    }



    public static void generator(GeneratorConfig config) {

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(config.getDriverName());
        dsc.setUsername(config.getUser());
        dsc.setPassword(config.getPassword());
        dsc.setUrl(config.getUrl());

        // 模板文件
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("controller.vm");
        templateConfig.setEntity("domain.vm");
        templateConfig.setMapper("mapper.vm");
        templateConfig.setXml("mapperxml.vm");
        templateConfig.setService(null);
        templateConfig.setServiceImpl("serviceimpl.vm");

        config.getModel()
                .stream()
                .forEach(modelConfig -> {
                    AutoGenerator mpg = new AutoGenerator();
                    // 全局配置
                    GlobalConfig gc = new GlobalConfig();
                    gc.setOutputDir(config.getDir());
                    gc.setAuthor("lqh");
                    gc.setFileOverride(true); //是否覆盖
                    gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
                    gc.setEnableCache(false);// XML 二级缓存
                    gc.setBaseResultMap(true);// XML ResultMap
                    gc.setBaseColumnList(true);// XML columList
                    gc.setServiceImplName("%sService");
                    mpg.setGlobalConfig(gc);
                    mpg.setDataSource(dsc);

                    // 策略配置
                    StrategyConfig strategy = new StrategyConfig();
                    strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
                    strategy.setEntityLombokModel(false);
                    strategy.setRestControllerStyle(true);
                    if(!modelConfig.getTables().equals("*")){
                        strategy.setInclude(modelConfig.getTables().split(","));
                    }
                    // strategy.setInclude(new String[] { "user" }); // 需要生成的表
                    // strategy.setExclude(new String[]{"test"}); // 排除生成的表
                    strategy.setEntityBuilderModel(true);
                    mpg.setStrategy(strategy);

                    // 包配置
                    PackageConfig pc = new PackageConfig();
                    pc.setParent(config.getProjectPackage());
                    pc.setModuleName(modelConfig.getName());
                    pc.setController("controller");
                    pc.setEntity("domain");
                    pc.setMapper("mapper");
                    pc.setServiceImpl("service");
                    pc.setXml("mapper");
                    mpg.setPackageInfo(pc);
                    mpg.setTemplate(templateConfig);

                    // 执行生成
                    mpg.execute();
                });
    }

}
