package com.aaa.dao;/*
 */

import com.aaa.entity.SysMenuPath;

import java.util.List;

public interface SysMenuPathDao {

    //查询资源详情，路径对应的操作
    List<SysMenuPath> findSysMenu();

    //添加资源路径
    Integer addPath(SysMenuPath sysMenuPath);

    //删除资源路径
    Integer deletePath(Integer id);

    //查询资源是否重复
    SysMenuPath findMenuPathByUrl(Integer id,String pathurl);

    //修改资源
    Integer updPath(SysMenuPath sysMenuPath);

}
