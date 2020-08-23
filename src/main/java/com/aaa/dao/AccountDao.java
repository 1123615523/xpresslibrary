package com.aaa.dao;

import com.aaa.entity.SysAccount;
import com.aaa.entity.SysUser;

/**
 * @author 程亚辉
 * */

public interface AccountDao {
    SysUser findById(Integer id);
}
