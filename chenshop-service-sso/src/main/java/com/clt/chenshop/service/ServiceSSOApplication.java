package com.clt.chenshop.service;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2019-01-02 15:49
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.clt.chenshop.common.mapper")
public class ServiceSSOApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSSOApplication.class,args);
        Main.main(args);
    }
}
