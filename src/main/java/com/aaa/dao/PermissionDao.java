package com.aaa.dao;/*
 */

import com.aaa.entity.SysAccount;

import java.util.List;
import java.util.Map;

/**
 * @author 王登科
 */

public interface PermissionDao {

    //根据登录账号查询账号信息
    SysAccount findByAccount(String account);

    //根据登录账号拿出角色信息
    List<String> findRoleByAccount(String account);

    //根据登录账号拿出桥梁表中分配的权限
    List<String> findPathUrlByAccount(String account);

    //跟据登录的角色拿出桥梁表中的权限
    List<Map<String, Object>> findParentId(Integer account, Integer menupid);

    //查询系统一级权限
    List<Map<String, Object>> findPermissionInfo(Integer menupid);

    /**根据角色id查询所拥有权限*/
    List<Map<String,Object>> findByRoleId(Integer id);



}