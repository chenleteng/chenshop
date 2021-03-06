package com.clt.chenshop.service;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.clt.chenshop.common.mapper")
public class ServicePortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePortalApplication.class);
        Main.main(args);
    }
}
