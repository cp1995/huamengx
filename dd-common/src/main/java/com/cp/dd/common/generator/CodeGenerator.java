package com.cp.dd.common.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * MyBatis Plus 代码生成类
 * 该代码生成不会替换已存在的文件，如果需要修改请手动或者删除原文件再生成代码
 *
 * <p>
 * 使用说明：
 * 运行main方法，例如:

 * 模块名（比如 sys）
 * sys
 * 表名，多个英文逗号分割（比如 sys_user）
 * sys_user
 *
 * @author chengp
 */
public class CodeGenerator {

    /**
     * 工程信息和包信息
     */
    private String basePackage = "com.cp.dd.common";
    private String baseAdminPackage = "com.cp.dd.web";

    public static void main(String[] args) {
        new CodeGenerator().generate();
    }

    /**
     * 读取控制台内容
     *
     * @param tip 提示
     * @return 输入内容
     */
    private String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 代码生成
     */
    private void generate() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        /*
         * 全局配置
         */
        GlobalConfig gc = new GlobalConfig();
        String projectRootPath = System.getProperty("user.dir");
        // gc.setAuthor(scanner("代码生成者author（比如 chengp）"));
        gc.setAuthor("CodeGenerator");
        gc.setOpen(false);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        /*
         * 数据源配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("generator/generator.properties"));
            dsc.setDriverName(properties.getProperty("driver"));
            dsc.setUrl(properties.getProperty("url"));
            dsc.setUsername(properties.getProperty("username"));
            dsc.setPassword(properties.getProperty("password"));
        } catch (Exception e) {
            throw new RuntimeException("数据源配置错误", e);
        }
        mpg.setDataSource(dsc);

        /*
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        String moduleName = scanner("模块名（比如 sys）");
        // pc.setModuleName(scanner("模块名（比如 sys）"));
        pc.setParent(null);
        pc.setEntity("com.cp.dd.common.entity." + moduleName);
        pc.setMapper("com.cp.dd.common.mapper." + moduleName);
        pc.setService("com.cp.dd.web.service." + moduleName);
        pc.setServiceImpl("com.cp.dd.web.service.impl." + moduleName);
        pc.setController("com.cp.dd.web.controller." + moduleName);
        mpg.setPackageInfo(pc);

        // 工程路径设置
        String commonProjectPath = projectRootPath + "/dd-common";
        String serviceProjectPath = projectRootPath + "/dd-web-service" ;
        String controllerProjectPath = projectRootPath + "/dd-web" ;

        /*
         * 自定义配置
         */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        /*
         * 自定义输出配置
         */
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        String templatePath = "/generator/templates";
        // mapper.xml
        focList.add(new FileOutConfig(templatePath + "/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return commonProjectPath + "/src/main/resources/mapper/" + moduleName + '/' +
                        tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        // Model
        focList.add(new FileOutConfig(templatePath + "/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return commonProjectPath + "/src/main/java/" + basePackage.replaceAll("\\.", "/") + "/entity/"
                        + moduleName + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        // Mapper
        focList.add(new FileOutConfig(templatePath + "/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return commonProjectPath + "/src/main/java/" + basePackage.replaceAll("\\.", "/") + "/mapper/"
                        + moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        // IService
        focList.add(new FileOutConfig(templatePath + "/Service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return serviceProjectPath + "/src/main/java/" + baseAdminPackage.replaceAll("\\.", "/") + "/service/"
                        + moduleName + "/I" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });
        // ServiceImpl
        focList.add(new FileOutConfig(templatePath + "/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return serviceProjectPath + "/src/main/java/" + baseAdminPackage.replaceAll("\\.", "/") + "/service/impl/"
                        + moduleName + "/" + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
            }
        });
        // Controller
        focList.add(new FileOutConfig(templatePath + "/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return controllerProjectPath + "/src/main/java/" + baseAdminPackage.replaceAll("\\.", "/") + "/controller/"
                        + moduleName + "/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        templateConfig.setXml(null);
        templateConfig.setEntity(null);
        templateConfig.setMapper(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        mpg.setTemplate(templateConfig);

        /*
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名（支持正则），多个英文逗号分割（比如 sys_user 或 ^sys_\\w*$）").split(","));
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        // 设置自动填充字段
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("create_time", FieldFill.INSERT));
        tableFills.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        tableFills.add(new TableFill("create_by", FieldFill.INSERT));
        tableFills.add(new TableFill("update_by", FieldFill.INSERT_UPDATE));
        tableFills.add(new TableFill("create_dept", FieldFill.INSERT));
        strategy.setTableFillList(tableFills);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
