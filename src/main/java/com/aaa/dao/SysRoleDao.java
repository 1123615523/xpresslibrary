package com.aaa.dao;

import com.aaa.entity.SysRole;

import java.util.List;

public interface SysRoleDao {
    /**查询所有角色*/
    List<SysRole> findAll();
}
