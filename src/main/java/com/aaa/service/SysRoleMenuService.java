package com.aaa.service;

public interface SysRoleMenuService {

    /**为角色添加权限*/
    Integer add(Integer rid,Integer pid);

    /**为角色撤销权限*/
    Integer del(Integer rid);
}
