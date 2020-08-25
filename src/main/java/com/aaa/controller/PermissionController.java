package com.aaa.controller;/*
 */

import com.aaa.service.PermissionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("permission")
public class PermissionController {

    @Resource
    PermissionService permissionService;

    @RequestMapping("findPermiSsionInfo")
    public Object findPermiSsionInfo(){
        List<Map<String, Object>> info = permissionService.findPermissionInfo();
        return info;
    }

    /**根据角色id查询所拥有权限*/
    @RequestMapping("findByRoleId")
    public Object findByRoleId(Integer id){
        List<Map<String, Object>> byRoleId = permissionService.findByRoleId(id);
        return byRoleId;
    }


}
