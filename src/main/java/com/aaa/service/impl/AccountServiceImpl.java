package com.aaa.service.impl;

import com.aaa.dao.AccountDao;
import com.aaa.entity.SysAccount;
import com.aaa.entity.SysUser;
import com.aaa.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    /**根据id修改个人密码*/
    @Override
    public Integer updateByPwd(SysAccount sysAccount) {
        return accountDao.updateByPwd(sysAccount);
    }



}
