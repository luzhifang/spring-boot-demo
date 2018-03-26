package com.company.properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootConfiguration
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceProperties {
    // 数据库连接地址
    private String url;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 数据库驱动
    private String driverClassName;
    // 数据库类型
    private String databaseType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        if(url.toLowerCase().indexOf("sqlserver") > -1){
            this.databaseType = "sqlserver";
        } else if(url.toLowerCase().indexOf("oracle") > -1){
            this.databaseType = "oracle";
        } else {
            this.databaseType = "mysql";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDatabaseType() {
        return databaseType;
    }
}
