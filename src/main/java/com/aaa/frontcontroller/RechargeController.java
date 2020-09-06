package com.aaa.frontcontroller;/*
 */

import com.aaa.service.CustomerService;
import com.aaa.service.RechargeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("recharge")
public class RechargeController {

    @Resource
    RechargeService rechargeService;

    @Resource
    CustomerService customerService;

    @RequestMapping("findCustomerInfo")
    @ResponseBody
    public Object findCustomerInfo(Integer cusid){
        return customerService.updLogin(cusid);
    }

    @RequestMapping("findRecharge")
    @ResponseBody
    public Object findRecharge(Integer cusid){
        return rechargeService.findRechargeInfo(cusid);
    }

}
