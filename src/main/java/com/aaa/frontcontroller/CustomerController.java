package com.aaa.frontcontroller;

import com.aaa.entity.Customerinfo;
import com.aaa.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping("add")
    public Object add(Customerinfo customerinfo){
        Integer add = customerService.add(customerinfo);
        return add;
    }
}
