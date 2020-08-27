package com.aaa.service;

import com.aaa.entity.Customerinfo;

/**
 * @author 程亚辉
 */
public interface CustomerService {

    /**注册*/
    Integer add(Customerinfo customerinfo);

    /**登录*/
    Customerinfo bypwd(String customertel,String customeremail,String customerpwd);
}
