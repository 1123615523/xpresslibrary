package com.aaa.service;/*
 */

import com.aaa.entity.Recharge;

import java.util.Map;

public interface RechargeService {


    //查询用户的账户流水明细
    Map<String,Object> findRechargeInfo(Integer cusid);

    //录入用户充钱明细
    Integer addRecharge(Recharge recharge);

    //录入解锁文档明细
    Integer recording(Recharge recharge);


}
