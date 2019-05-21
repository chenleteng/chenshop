package com.clt.chenshop.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        String a = "123";
        newkey(1, 1);
        return "test";
    }

    public boolean newkey(int i, int a) {
        boolean f = true;
        if (i == a) {
            f = false;
        }
        return f;
    }
}
