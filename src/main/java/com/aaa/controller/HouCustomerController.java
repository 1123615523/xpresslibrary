package com.aaa.controller;/*
 */

import com.aaa.entity.Customerinfo;
import com.aaa.service.CustomerService;
import com.aaa.utils.PageModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("houCustomer")
public class HouCustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping("findCustomer")
    public Object findCustomer(PageModel<Customerinfo> pm){
        pm = customerService.houCustomerInfo(pm);
        return pm;
    }

}
