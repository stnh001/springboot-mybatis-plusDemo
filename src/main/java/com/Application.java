package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 管理控制台web端
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.mybatisplus.config",
        "com.mybatisplus.controller",
        "com.mybatisplus.service"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
