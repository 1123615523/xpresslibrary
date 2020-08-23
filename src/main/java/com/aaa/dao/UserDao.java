package com.aaa.dao;/*
 */

import com.aaa.entity.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王登科
 */

public interface UserDao {

    List<SysUser> findUserInfo();

    /**添加员工*/
    Integer add(SysUser sysUser);

    /**修改员工*/
    Integer update(SysUser sysUser);



}
