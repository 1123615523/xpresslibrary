package com.aaa.controller;/*
 */

import com.aaa.service.PermissionService;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
