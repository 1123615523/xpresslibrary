package com.aaa.dao;

public interface SysRoleMenuDao {

    /**为角色添加权限*/
    Integer add(Integer rid,Integer pid);

    /**为角色撤销权限*/
    Integer del(Integer rid);
}
