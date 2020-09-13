package com.shop.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@MapperScan("com.shop.web.dao.mapper")
@SpringBootApplication
public class ShopApplication {

    private static String project_env;

    @Value("${application.env}")
    public void setProjectEnv(String pejectEnv) {
        ShopApplication.project_env = pejectEnv;
    }

    public static void main(String[] args) {

        SpringApplication.run(ShopApplication.class);
        System.out.println("shop environment :" + project_env);

    }
}
