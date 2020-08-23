package com.aaa.service.impl;

import com.aaa.dao.AccountDao;
import com.aaa.entity.SysAccount;
import com.aaa.entity.SysUser;
import com.aaa.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    /**根据id获取个人信息*/
    @Override
    public SysUser findById(Integer id) {
        return accountDao.findById(id);
    }
}
