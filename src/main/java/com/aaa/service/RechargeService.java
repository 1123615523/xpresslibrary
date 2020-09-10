package com.aaa.service;/*
 */

import com.aaa.entity.Recharge;
import com.aaa.utils.PageModel;

import java.util.List;
import java.util.Map;

public interface RechargeService {


    //查询用户的账户流水明细
    Map<String,Object> findRechargeInfo(Integer cusid);

    //录入用户充钱明细
    Integer addRecharge(Recharge recharge);

    //录入解锁文档明细
    Integer recording(Recharge recharge);

    //----------------------后台方法分割线--------------------------

    //用户充值记录
    PageModel<Recharge> houFindRecharge(PageModel<Recharge> pm);

    //用户购买文档记录
    PageModel<Recharge> houFindDocuemnt(PageModel<Recharge> pm);

    //报表信息
    List<Map<String,Object>> baobiao();

}
