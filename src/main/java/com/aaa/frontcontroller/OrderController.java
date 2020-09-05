package com.aaa.frontcontroller;

import com.aaa.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    OrdersService orderService;


    @RequestMapping("documentbuy")
    public String documentbuy(Integer did, HttpSession session){
        orderService.documentbuy(did,session);
        return "pay/order";
    }
}
