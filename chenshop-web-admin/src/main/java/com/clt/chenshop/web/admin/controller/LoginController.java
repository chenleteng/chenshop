package com.clt.chenshop.web.admin.controller;

import com.clt.chenshop.common.constant.ResponseConstant;
import com.clt.chenshop.common.pojo.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *登录
 */
@Controller
public class LoginController {

    /**
     *登录页面
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    /**
     *登录请求，成功后跳转页面
     */
    @RequestMapping(value = "main",method = RequestMethod.POST)
    public String main(RedirectAttributes redirectAttributes , String email, String password){
        if ("123@123".equals(email) && "123".equals(password)){
            return "main";
        }

        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(ResponseConstant.LOGIN_FAIL_STATUS_PASSWORD);
        baseResult.setMsg(ResponseConstant.LOGIN_FAIL_MSG_PASSWORD);
        redirectAttributes.addFlashAttribute("result",baseResult);

        return "redirect:login";

    }

}
