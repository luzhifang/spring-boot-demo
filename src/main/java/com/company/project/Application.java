package com.company.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application
//extends SpringBootServletInitializer //打war包需要
{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 打war包需要
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(Application.class);
        return super.configure(builder);
    }*/
}

