package com.aaa.dao;

import com.aaa.entity.Customerinfo;

public interface CustomerDao {
    /**注册*/
    Integer add(Customerinfo customerinfo);

    /**登录*/
    Customerinfo bypwd(String customertel,String customeremail,String customerpwd);

}
