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
    public Integer add(Customerinfo customerinfo) {
        return customerDao.add(customerinfo);
    }
}