package com.aaa.service;

import com.aaa.entity.Orders;
import com.aaa.utils.PageModel;

import javax.servlet.http.HttpSession;

public interface OrdersService {


    /**购买方法*/
    public Integer documentbuy(Integer did, HttpSession session);

    //查询我的订单
    PageModel<Orders> findOrderInfo(PageModel<Orders> pm);

    //录入订单明细
    Integer addOrder(Orders orders);

    //查询此人是否已经下载了此文档
    Integer findOrderCount(Integer cusid,Integer did);

}
