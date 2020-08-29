package com.aaa.frontcontroller;/*
 */

import com.aaa.service.SigninService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("signin")
public class SigninController {

    @Resource
    SigninService signinService;

    @RequestMapping("find")
    @ResponseBody
    public Object find(Integer cusid){
        return signinService.findSignInfo(cusid);
    }


}
