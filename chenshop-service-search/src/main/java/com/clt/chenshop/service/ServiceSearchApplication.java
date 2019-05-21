package com.clt.chenshop.service;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-26 17:00
 **/

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.clt.chenshop.common.mapper")
public class ServiceSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSearchApplication.class,args);
        Main.main(args);
    }
}
