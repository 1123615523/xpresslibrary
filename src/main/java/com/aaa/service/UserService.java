package com.aaa.service;/*
 */

import com.aaa.entity.SysUser;
import com.aaa.utils.PageModel;

/**
 * @author 王登科
 */

public interface UserService {

    PageModel<SysUser> findUserInfo(PageModel<SysUser> pm);

}
