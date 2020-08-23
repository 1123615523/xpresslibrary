package com.aaa.service;/*
 */

import com.aaa.entity.SysUser;
import com.aaa.utils.PageModel;

import java.util.List;

/**
 * @author 王登科
 */

public interface UserService {

    PageModel<SysUser> findUserInfo(PageModel<SysUser> pm);

    /**添加员工*/
    Integer add(SysUser sysUser);

    /**修改员工*/
    Integer update(SysUser sysUser);

}
