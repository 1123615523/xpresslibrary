package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot启动注解类
 */

@MapperScan("com.aaa.dao")
@SpringBootApplication
@EnableTransactionManagement
public class XpresslibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(XpresslibraryApplication.class, args);
    }

}
