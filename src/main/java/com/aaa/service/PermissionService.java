package com.aaa.service;/*
 */

import com.aaa.entity.SysAccount;

import java.util.List;
import java.util.Map;

/**
 * @author 王登科
 */

public interface PermissionService {

    List<Map<String,Object>> findPermission(Integer accountid);

    SysAccount findByAccount(String account);

    List<String> findRoleByAccount(String account);

    List<String> findPathUrlByAccount(String account);

    //查询系统权限
    List<Map<String,Object>> findPermissionInfo();

    /**根据角色id查询所拥有权限*/
    List<Map<String,Object>> findByRoleId(Integer id);




}
