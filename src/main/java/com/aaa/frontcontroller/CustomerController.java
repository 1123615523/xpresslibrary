package com.aaa.frontcontroller;

import com.aaa.entity.Customerinfo;
import com.aaa.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping("add")
    public Object add(Customerinfo customerinfo){
        customerinfo.setCustomerstate(1);
        Integer add = customerService.add(customerinfo);
        return add;
    }

    @RequestMapping("bypwd")
    public Object bypwd(String customertel, String customeremail, String customerpwd, HttpSession session){
        Customerinfo bypwd = customerService.bypwd(customertel, customeremail, customerpwd);
        session.setAttribute("customer",bypwd);
        System.out.println(bypwd);
        return bypwd;
    }
}
