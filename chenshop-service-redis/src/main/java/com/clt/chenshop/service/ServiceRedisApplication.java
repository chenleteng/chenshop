package com.clt.chenshop.service;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-24 15:17
 **/
@SpringBootApplication
public class ServiceRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRedisApplication.class,args);
        Main.main(args);
    }
}
