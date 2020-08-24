package com.aaa.service;/*
 */

import com.aaa.entity.SysMenu;

import java.util.List;

public interface SysMenuService {


    List<SysMenu> findMenu();

    //修改权限菜单的重复验证
    SysMenu findMenuById(SysMenu sysMenu);

    //修改权限菜单
    Integer updMenu(SysMenu sysMenu);

}
