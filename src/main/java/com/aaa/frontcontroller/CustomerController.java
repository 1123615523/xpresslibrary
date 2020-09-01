package com.aaa.frontcontroller;

import com.aaa.entity.Customerinfo;
import com.aaa.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @ResponseBody
    @RequestMapping("updPassword")
    public Integer updPassword(Integer id,String pwd,HttpSession session){
        Integer res = customerService.updPassword(id, pwd);
        if(res > 0){
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("updSignature")
    public Integer updSignature(Integer id,String meno,HttpSession session){
        Integer res = customerService.updSignature(id, meno);
        if(res > 0){
            session.removeAttribute("cus");
            Customerinfo customerinfo = customerService.updLogin(id);
            session.setAttribute("cus",customerinfo);
            return 1;
        }
        return 0;
    }

    @RequestMapping("upd")
    @ResponseBody
    public Integer upd(@RequestBody Customerinfo customerinfo){
        System.out.println(customerinfo.toString());
        Integer updCustomer = customerService.updCustomer(customerinfo);
        if(updCustomer > 0){
            return 1;
        }
        return 0;
    }

    @RequestMapping("updLogin")
    @ResponseBody
    public Integer updLogin(Integer id,HttpSession session){
        session.removeAttribute("cus");
        Customerinfo customerinfo = customerService.updLogin(id);
        if(null != customerinfo){
            session.setAttribute("cus",customerinfo);
            return 1;
        }
        return 0;
    }

    @RequestMapping("add")
    @ResponseBody
    public Object add(Customerinfo customerinfo){
        customerinfo.setCustomerstate(1);
        customerinfo.setCustomermoney(0.00);
        customerinfo.setCustomerpic("/static/wd/avatar_small.gif");
        return customerService.add(customerinfo);
    }

    @RequestMapping("bypwd")
    @ResponseBody
    public Integer bypwd(String customertel, String customeremail, String customerpwd, HttpSession session){
        Customerinfo bypwd = customerService.bypwd(customertel, customeremail, customerpwd);
        if(null != bypwd){
            session.setAttribute("cus",bypwd);
            return 1;
        }
        return 0;
    }

}
