package com.aaa.frontcontroller;

import com.aaa.entity.Orders;
import com.aaa.service.OrdersService;
import com.aaa.utils.PageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("order")
public class OrderController {

    @Resource
    OrdersService orderService;

    @RequestMapping("findOrderInfo")
    @ResponseBody
    public Object findOrderInfo(PageModel<Orders> pm){
        pm = orderService.findOrderInfo(pm);
        return pm;
    }


    @RequestMapping("documentbuy")
    @ResponseBody
    public Object documentbuy(Integer did, HttpSession session){
        return orderService.documentbuy(did, session);
    }
}
