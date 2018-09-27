package com.luwan;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器演示
 * </p>
 * @author luwan
 */
public class MpGenerator {

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D://");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("luwan");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");
        gc.setServiceName("MP%sService");
        gc.setServiceImplName("%sServiceDiy");
        gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123656");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mp?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix("bmd_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        // strategy.setInclude(new String[] { "user" }); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 字段名生成策略

        // 自定义实体父类
//         strategy.setSuperEntityClass("com.mybatisplus.entity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
//         strategy.setSuperMapperClass("com.mybatisplus.entity.EmployeeMapper");
        // 自定义 service 父类
//         strategy.setSuperServiceClass("com.mybatisplus.service");
        // 自定义 service 实现类父类
//         strategy.setSuperServiceImplClass("com.mybatisplus.service.impl");
        // 自定义 controller 父类
//         strategy.setSuperControllerClass("com.mybatisplus.controller");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
//        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("test");
        pc.setParent("com.mybatisplus");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

       // 自定义模板配置
         TemplateConfig tc = new TemplateConfig();
         /*tc.setController("com/mybatisplus/controller.java");
         tc.setEntity("com/mybatisplus/entity.java");
         tc.setMapper("com/mybatisplus/mapper.java");
         tc.setXml("com/mybatisplus/mapper.xml");
         tc.setService("com/mybatisplus/service");
         tc.setServiceImpl("com/mybatisplus/service/impl");*/
         mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
