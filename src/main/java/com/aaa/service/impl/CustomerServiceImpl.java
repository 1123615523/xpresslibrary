package com.aaa.service.impl;

import com.aaa.dao.CustomerDao;
import com.aaa.entity.Customerinfo;
import com.aaa.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao customerDao;

    @Override
    public Integer updPassword(Integer id, String pwd) {
        return customerDao.updPassword(id,pwd);
    }

    @Override
    public Integer updSignature(Integer id, String meno) {
        return customerDao.updSignature(id,meno);
    }

    @Override
    public Customerinfo updLogin(Integer id) {
        return customerDao.updLogin(id);
    }

    @Override
    public Integer updCustomer(Customerinfo customerinfo) {
        return customerDao.updCustomer(customerinfo);
    }

    @Override
    public Integer findCustomerByPhone(String phone) {
        Customerinfo customerByPhone = customerDao.findCustomerByPhone(phone);
        if(null != customerByPhone){
            return 1;
        }
        return 0;
    }

    @Override
    public Integer add(Customerinfo customerinfo) {
        return customerDao.add(customerinfo);
    }

    @Override
    public Customerinfo bypwd(String customertel, String customeremail, String customerpwd) {
        return customerDao.bypwd(customertel,customeremail,customerpwd);
    }
}
