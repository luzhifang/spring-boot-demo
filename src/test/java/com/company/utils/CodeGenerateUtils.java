package com.company.utils;

import com.alibaba.fastjson.JSONObject;
import com.company.properties.GeneratorProperties;
import com.company.domain.Column;
import com.google.common.io.Files;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

/**
 * 代码生成器工具类
 */
@Component
public class CodeGenerateUtils {

    public void generateDoFile(List<Column> columns, GeneratorProperties gp) throws Exception{
        final String suffix = ".java";
        final String path = gp.getProjectPath() + gp.getJavaPath() +
                packageConvertPath(gp.getBasePackage() + "." + gp.getDoPackage()) + gp.getDoNameUpperCamel() + suffix;
        final String templateName = "do.ftl";
        File mapperFile = new File(path);
        JSONObject data = (JSONObject) JSONObject.toJSON(gp);
        data.put("hasDate", false);
        data.put("hasBigDecimal", false);
        for (Column c: columns) {
            c.setDoField(CodeGenerateUtils.toHump(c.getColumnName().toLowerCase()));
            if (c.getColumnType().equals("date") || c.getColumnType().equals("datetime") || c.getColumnType().equals("timestamp")){
                data.put("hasDate", true);
            }
            if (c.getColumnType().equals("decimal") || c.getColumnType().equals("numeric") ){
                data.put("hasBigDecimal", true);
            }
        }
        data.put("columns",columns);
        generateFileByTemplate(templateName,mapperFile,data);
    }

    public void generateDtoFile(List<Column> columns, GeneratorProperties gp) throws Exception{
        final String suffix = "DTO.java";
        final String path = gp.getProjectPath() + gp.getJavaPath() +
                packageConvertPath(gp.getBasePackage() + "." + gp.getDtoPackage()) + gp.getDoNameUpperCamel() + suffix;
        final String templateName = "dto.ftl";
        File mapperFile = new File(path);
        JSONObject data = (JSONObject) JSONObject.toJSON(gp);
        generateFileByTemplate(templateName,mapperFile,data);
    }

    public void generateQoFile(List<Column> columns, GeneratorProperties gp) throws Exception{
        final String suffix = "QO.java";
        final String path = gp.getProjectPath() + gp.getJavaPath() +
                packageConvertPath(gp.getBasePackage() + "." +gp.getQoPackage()) + gp.getDoNameUpperCamel() + suffix;
        final String templateName = "qo.ftl";
        File mapperFile = new File(path);
        JSONObject data = (JSONObject) JSONObject.toJSON(gp);
        for (Column c: columns) {
            c.setDoField(CodeGenerateUtils.toHump(c.getColumnName().toLowerCase()));
        }
        data.put("columns",columns);
        generateFileByTemplate(templateName,mapperFile,data);
    }

    public void generateControllerFile(List<Column> columns, GeneratorProperties gp) throws Exception{
        final String suffix = "Controller.java";
        final String path = gp.getProjectPath() + gp.getJavaPath() +
                packageConvertPath(gp.getBasePackage() + "." +gp.getControllerPackage()) + gp.getDoNameUpperCamel() + suffix;
        final String templateName = "controller.ftl";
        File mapperFile = new File(path);
        JSONObject data = (JSONObject) JSONObject.toJSON(gp);
        data.put("baseRequestMapping", "/" + gp.getTableName().replaceAll("_", "/"));
        generateFileByTemplate(templateName,mapperFile,data);
    }

    public void generateServiceFile(List<Column> columns, GeneratorProperties gp) throws Exception{
        final String suffix = "Service.java";
        final String path = gp.getProjectPath() + gp.getJavaPath() +
                packageConvertPath(gp.getBasePackage() + "." +gp.getServicePackage()) + gp.getDoNameUpperCamel() + suffix;
        final String templateName = "service.ftl";
        File mapperFile = new File(path);
        JSONObject data = (JSONObject) JSONObject.toJSON(gp);
        generateFileByTemplate(templateName,mapperFile,data);
    }

    public void generateDaoFile(List<Column> columns, GeneratorProperties gp) throws Exception{
        final String suffix = "Dao.java";
        final String path = gp.getProjectPath() + gp.getJavaPath() +
                packageConvertPath(gp.getBasePackage() + "." +gp.getDaoPackage()) + gp.getDoNameUpperCamel() + suffix;
        final String templateName = "DAO.ftl";
        File mapperFile = new File(path);
        JSONObject data = (JSONObject) JSONObject.toJSON(gp);
        generateFileByTemplate(templateName,mapperFile,data);

    }

    public void generateMapperFile(List<Column> columns, GeneratorProperties gp) throws Exception{
        final String suffix = "Mapper.xml";
        final String path = gp.getProjectPath() + gp.getResourcesPath() + packageConvertPath(gp.getMapperDictionary()) + gp.getDoNameUpperCamel() + suffix;
        final String templateName = "mapper.ftl";
        File mapperFile = new File(path);
        JSONObject data = (JSONObject) JSONObject.toJSON(gp);
        for (Column c: columns) {
            c.setDoField(CodeGenerateUtils.toHump(c.getColumnName().toLowerCase()));
        }
        data.put("columns",columns);
        generateFileByTemplate(templateName,mapperFile,data);

    }

    public void generateFileByTemplate(final String templateName,File file, Object data) throws Exception{
        Template template = getTemplate(templateName);
        Files.createParentDirs(file);
        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(data,out);
    }

    public static String toHump(String str){
        StringBuffer sb = new StringBuffer();
        String [] arr = str.split("_");
        for (int i = 0; i < arr.length; i++) {
            sb.append((String.valueOf(arr[i].charAt(0))).toUpperCase() + arr[i].substring(1));
        }
        return sb.toString();
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

    private Template getTemplate(String templateName) throws IOException {
        Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        String templatePath = getClass().getClassLoader().getResource("").getPath()
                .replaceAll("target/test-classes/", "") + "/src/test/resources/templates/generator";
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg.getTemplate(templateName);
    }
}