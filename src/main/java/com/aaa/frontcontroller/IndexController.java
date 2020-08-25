package com.aaa.frontcontroller;/*
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 王登科
 */

@RequestMapping("Home")
@Controller
public class IndexController {

    //进入首页
    @RequestMapping("index")
    public String index(){
        return "Home/index";
    }

    //注册页面
    @RequestMapping("registered")
    public String registered(){
        return "Registered/index";
    }

    //登录页面
    @RequestMapping("login")
    public String login(){
        return "Login/index";
    }
}