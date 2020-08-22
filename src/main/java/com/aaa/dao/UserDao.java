package com.aaa.dao;/*
 */

import com.aaa.entity.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王登科
 */

public interface UserDao {

    @Select("select * from sys_user")
    List<SysUser> findUserInfo();

}
