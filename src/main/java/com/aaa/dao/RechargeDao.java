package com.aaa.dao;/*
 */

import com.aaa.entity.Recharge;

import java.util.List;

/**
 * @author 王登科
 */

public interface RechargeDao {

    //查询用户的全部账户流水信息
    List<Recharge> findRechargeInfo(Integer cusid);

    //收入信息
    double incomeInfo(Integer cusid);

    //支出信息
    double expenditureInfo(Integer cusid);

    //提现信息
    double withdrawInfo(Integer cusid);

    //录入消费信息
    Integer addRecharge(Recharge recharge);

}
