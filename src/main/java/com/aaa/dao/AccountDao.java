package com.aaa.dao;

import com.aaa.entity.SysAccount;
import com.aaa.entity.SysUser;

/**
 * @author 程亚辉
 * */

public interface AccountDao {
    /**根据账号id查询员工信息*/
    SysUser findById(Integer id);

    /**修改账号密码*/
    Integer updateByPwd(SysAccount sysAccount);
}
