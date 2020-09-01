package com.aaa.frontcontroller;/*
 */

import com.aaa.entity.Documentation;
import com.aaa.service.DocumentationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 王登科
 */

@RequestMapping("Home")
@Controller
public class IndexController {

    @Resource
    DocumentationService documentationService;

    //进入阅读文档页面
    @RequestMapping("read")
    public String read(){
        return "Read/index";
    }

    //进入个人头像页面
    @RequestMapping("avatar")
    public String avatar(){
        return "Person/avatar";
    }

    //进入个人余额页面
    @RequestMapping("blance")
    public String blance(){
        return "Person/blance";
    }

    //进入签到页面
    @RequestMapping("signin")
    public String signin(){
        return "Person/signin";
    }

    //进入修改密码页面
    @RequestMapping("password")
    public String password(){
        return "Person/password";
    }

    //进入个人信息的签名页面
    @RequestMapping("signature")
    public String signature(){
        return "Person/signature";
    }

    //进入个人中的基本信息
    @RequestMapping("userinfo")
    public String userinfo(){
        return "Person/index";
    }

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
        return "Login/login";
    }

    //进入个人中心
    @RequestMapping("user")
    public String user(){
        return "Upload/index";
    }

    //退出登录
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("cus");
        return "redirect:index";
    }

    @RequestMapping("reads")
    public String reads(Integer did, Model model){
        Documentation findbydid = documentationService.findbydid(did);
        model.addAttribute("documentation",findbydid);
        return "Read/read";
    }

}