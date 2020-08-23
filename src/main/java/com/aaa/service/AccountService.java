package com.aaa.service;

import com.aaa.entity.SysAccount;
import com.aaa.entity.SysUser;

public interface AccountService {
    SysUser findById(Integer id);
}
