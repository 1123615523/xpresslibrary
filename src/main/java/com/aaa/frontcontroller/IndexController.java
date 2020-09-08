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

    //打开提现页面
    @RequestMapping("tixian")
    public String tixian(){
        return "pay/tixian";
    }

    //打开收藏信息窗体
    @RequestMapping("shoucang")
    public String fenceInfo(){
        return "Favorites/shoucang";
    }

    //打开关注页面
    @RequestMapping("guanzhu")
    public String guanzhu(){
        return "Favorites/guanzhu";
    }

    //打开我的文档信息
    @RequestMapping("wendang")
    public String wendang(){
        return "Favorites/wendang";
    }

    //打开粉丝信息的窗体
    @RequestMapping("findFence")
    public String fenFence(Integer cusid,Model model){
        model.addAttribute("customerid",cusid);
        return "User/fenCe";
    }

    //进入支付成功订单详情页面
    @RequestMapping("OrderInfo")
    public String OrderInfo(Model model){
        //在这里携带你的订单参数
        return "pay/order";
    }

    //进入资源分类详情页面
    @RequestMapping("ResourceDetails")
    public String ResourceDetails(Integer did,Model model){
        model.addAttribute("did",did);
        return "Home/indexDetails";
    }

    //进入个人信息主页
    @RequestMapping("UserInfoPerson")
    public String UserInfoPerson(Integer cid,Model model){
        model.addAttribute("customerid",cid);
        return "User/index";
    }

    //进入求助评论详情
    @RequestMapping("HelpDetails")
    public String HelpDetails(Integer id,Integer status,Double money,Model model){
        model.addAttribute("helpid",id);
        model.addAttribute("status",status);
        model.addAttribute("money",money);
        return "Help/helpAdoption";
    }

    //进入求助信息详细页面
    @RequestMapping("helpDetailsInfo")
    public String helpDetailsInfo(){
        return "Help/helpDetailsInfo";
    }

    //下载充值页面
    @RequestMapping("payInfo")
    public String payInfo(){
        return "pay/index";
    }

    //进入悬赏详情页面
    @RequestMapping("helpInfo")
    public String helpInfo(Integer id, Model model){
        model.addAttribute("helpid",id);
        return "Help/helpInfo";
    }

    //进入发布求助页面
    @RequestMapping("addHelp")
    public String addHelp(){
        return "Help/addHelp";
    }

    //进入求助页面
    @RequestMapping("help")
    public String help(){
        return "Help/index";
    }

    //进入充值页面
    @RequestMapping("recharge")
    public String recharge(){
        return "Person/recharge";
    }

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

    //进入个人中心登录
    @RequestMapping("loginUser")
    public String loginUser(){
        return "Login/index";
    }

    /**进入订单页面*/
    @RequestMapping("orderInfo")
     public String orderInfo(){
        return "Order/orderInfo";
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
    public String reads(Integer did,Integer cusid,Model model){
        Documentation findbydid = documentationService.findbydid(did);
        model.addAttribute("documentation",findbydid);
        model.addAttribute("cusid",cusid);
        return "Read/read";
    }

}