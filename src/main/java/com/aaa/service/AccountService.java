package com.aaa.service;

import com.aaa.entity.SysAccount;
import com.aaa.entity.SysUser;

import java.util.List;

public interface AccountService {
    SysUser findById(Integer id);

    /**修改账号密码*/
    Integer updateByPwd(SysAccount sysAccount);

}
