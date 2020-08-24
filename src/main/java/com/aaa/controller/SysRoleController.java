package com.aaa.controller;


import com.aaa.service.SysRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sysrole")
public class SysRoleController {

    @Resource
    SysRoleService sysRoleService;

    @RequestMapping("findAll")
    public Object findAll(){
        return sysRoleService.findAll();
    }
}
