package com.aaa.service;

import com.aaa.entity.Customerinfo;

import java.util.Map;

/**
 * @author 程亚辉
 */
public interface CustomerService {

    /**注册*/
    Integer add(Customerinfo customerinfo);

    /**登录*/
    Customerinfo bypwd(String customertel,String customeremail,String customerpwd);

    /*验证手机号是否重复*/
    Integer findCustomerByPhone(String phone);

    //修改用户的基本信息
    Integer updCustomer(Customerinfo customerinfo);

    //修改成功后刷新用户的session信息
    Customerinfo updLogin(Integer id);

    //修改用户的签名信息
    Integer updSignature(Integer id,String meno);

    //修改用户密码
    Integer updPassword(Integer id,String pwd);

    //充值成功修改用户余额
    Integer updMoney(Integer cusid,Double money);

    /**修改头像*/
    Integer editFile(Customerinfo customerinfo);


    /**根据用户id获取用户信息*/
    Customerinfo findbycid(Integer customerid);

    /**关注操作时，对关注量进行修改*/
    Integer updateattention(Integer customerfence,Integer youid);

    //查询个人信息主页以及个人资源
    Map<String,Object> findUserInfo(Integer cusid);

}
