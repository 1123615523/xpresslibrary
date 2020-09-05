package com.aaa.dao;

import com.aaa.entity.Orders;

public interface OrdersDao {
    /**添加订单信息*/
    Integer documentbuy(Orders orders);
}
