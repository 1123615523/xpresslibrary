package com.aaa.dao;

import com.aaa.entity.Customerinfo;

public interface CustomerDao {
    /**注册*/
    Integer add(Customerinfo customerinfo);

    /**登录*/
    Customerinfo bypwd(String customertel,String customeremail,String customerpwd);

    /*注册验证手机号是否存在*/
    Customerinfo findCustomerByPhone(String phone);

    //修改用户的基本信息
    Integer updCustomer(Customerinfo customerinfo);

    //修改成功后刷新用户的session信息
    Customerinfo updLogin(Integer id);

    //修改用户的签名信息
    Integer updSignature(Integer id,String meno);

    //修改用户密码
    Integer updPassword(Integer id,String pwd);

    //签到成功修改积分余额
    Integer updMoney(Integer id,double money);

}
