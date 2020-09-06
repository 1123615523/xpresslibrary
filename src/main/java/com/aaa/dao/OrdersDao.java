package com.aaa.dao;

import com.aaa.entity.Orders;

import java.util.List;

public interface OrdersDao {
    /**添加订单信息*/
    Integer documentbuy(Orders orders);

    //查询自己的订单信息
    List<Orders> findOrderInfo(Integer cusid);

}
