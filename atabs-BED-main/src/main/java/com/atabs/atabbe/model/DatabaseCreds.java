package com.atabs.atabbe.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ComponentScan
public class DatabaseCreds {
    Properties springProperties = new Properties();


    private String username;

    private String password;
    private String dbName = "coop";

    public String getUsername() {
        return username;
    }
//    @Value("${spring.datasource.username}")
    public void setUsername(String username) {
        this.username =  springProperties.getProperty("spring.datasource.username");
    }

    public String getPassword() {
        return password;
    }
    @Value("${spring.datasource.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
