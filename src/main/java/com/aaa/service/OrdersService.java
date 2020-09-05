package com.aaa.service;

import javax.servlet.http.HttpSession;

public interface OrdersService {


    /**购买方法*/
    public void documentbuy(Integer did, HttpSession session);
}
