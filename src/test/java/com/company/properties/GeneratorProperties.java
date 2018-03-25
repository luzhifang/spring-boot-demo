package com.company.properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootConfiguration
@ConfigurationProperties(prefix = "generator")
public class GeneratorProperties {
    // 项目路径
    private String projectPath = getClass().getClassLoader().getResource("").getPath()
            .replaceAll("target/test-classes/", "");
    // java文件存放路径  默认是maven的src/main/java
    private String javaPath;
    // 配置文件存放路径  默认是maven的src/main/resources
    private String resourcesPath;
    // mapper文件存放路径  默认是mapper
    private String mapperDictionary;
    // freemarker模板存放路径
    private String templatePath;
    // author
    private String author;
    // 文件生成日期
    private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    // 基础包名  一般是com.公司名.项目名...
    private String basePackage;
    // do文件存放
    private String doPackage;
    // dto文件存放
    private String dtoPackage;
    // qo文件存放
    private String qoPackage;
    // dao文件存放
    private String daoPackage;
    // service文件存放
    private String servicePackage;
    // controller文件存放
    private String controllerPackage;
    // 数据库名
    private String schemaName;
    // 表名
    private String tableName;
    // 表注释
    private String tableComment;
    // java类文件前缀名  首字母大写驼峰
    private String doNameUpperCamel;

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getMapperDictionary() {
        return mapperDictionary;
    }

    public void setMapperDictionary(String mapperDictionary) {
        this.mapperDictionary = mapperDictionary;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getDoPackage() {
        return doPackage;
    }

    public void setDoPackage(String doPackage) {
        this.doPackage = doPackage;
    }

    public String getDtoPackage() {
        return dtoPackage;
    }

    public void setDtoPackage(String dtoPackage) {
        this.dtoPackage = dtoPackage;
    }

    public String getQoPackage() {
        return qoPackage;
    }

    public void setQoPackage(String qoPackage) {
        this.qoPackage = qoPackage;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getDoNameUpperCamel() {
        return doNameUpperCamel;
    }

    public void setDoNameUpperCamel(String doNameUpperCamel) {
        this.doNameUpperCamel = doNameUpperCamel;
    }
}
