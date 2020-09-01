package com.aaa.dao;/*
 */

import com.aaa.entity.Signin;

import java.util.Date;
import java.util.List;

public interface SigninDao {

    //登录后查询自己的签到信息
    List<Signin> findSigninInfo(Integer cusid);

    //查询自己签到次数
    Integer findCount(Integer cusid);

    //签到收益
    Double findMoney(Integer cusid);

    //最近签到时间
    Date findTime(Integer cusid);

    //签到成功，添加签到记录
    Integer addSignin(Signin signin);

}
