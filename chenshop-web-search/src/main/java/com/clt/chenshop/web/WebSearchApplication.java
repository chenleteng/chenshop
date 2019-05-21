package com.clt.chenshop.web;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-27 14:37
 **/

@SpringBootApplication
public class WebSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSearchApplication.class,args);
        Main.main(args);
    }
}
