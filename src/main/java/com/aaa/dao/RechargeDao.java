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

    /**购买文档时创建消费记录*/
    Integer recording(Recharge recharge);

    //----------------------后台方法接口分割线----------------------------

    //后台查询充值
    List<Recharge> houFindRecharge();

    //后台查询文档购买
    List<Recharge> houFindDocuemnt();

}
