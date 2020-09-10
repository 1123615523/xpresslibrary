package com.aaa.controller;/*
 */

import com.aaa.entity.Recharge;
import com.aaa.service.RechargeService;
import com.aaa.utils.PageModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("houRecharge")
public class HouRechargeController {

    @Resource
    RechargeService rechargeService;

    @RequestMapping("baobiao")
    public Object baobiao(){
        return rechargeService.baobiao();
    }

    @RequestMapping("houFindRecharge")
    public Object houFindRecharge(PageModel<Recharge> pm){
        pm = rechargeService.houFindRecharge(pm);
        return pm;
    }

    @RequestMapping("houFindDocuemnt")
    public Object houFindDocuemnt(PageModel<Recharge> pm){
        pm = rechargeService.houFindDocuemnt(pm);
        return pm;
    }

}
