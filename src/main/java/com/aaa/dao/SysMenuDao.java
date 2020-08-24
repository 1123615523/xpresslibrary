package com.aaa.dao;/*
 */

import com.aaa.entity.SysMenu;

import java.util.List;

public interface SysMenuDao {

    List<SysMenu> findMenu();

    //修改权限菜单的重复验证
    SysMenu findMenuById(SysMenu sysMenu);

    //修改权限菜单
    Integer updMenu(SysMenu sysMenu);

}
