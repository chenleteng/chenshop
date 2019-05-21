package com.clt.chenshop.web.sso.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbUser;
import com.clt.chenshop.service.sso.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2019-01-02 15:40
 **/

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Reference(version = DubboVersionConstant.DUBBO_SSO_SENTINEL_VERSION)
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @ResponseBody
    @RequestMapping(value = "check/{param}/{type}",method = RequestMethod.GET)
    public BaseResult check(@PathVariable(name = "param") String param,@PathVariable(name = "type") Integer type){
        return userService.check(param,type);
    }

    @ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResult register(TbUser tbUser){
        return userService.register(tbUser);
    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(String username, String password , HttpServletRequest request, HttpServletResponse response){
        return userService.login(username,password);
    }

}
