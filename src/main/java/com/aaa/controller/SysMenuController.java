package com.aaa.controller;/*
 */

import com.aaa.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Resource
    SysMenuService sysMenuService;

    @RequestMapping("findMenu")
    public Object findMenu(){
        return sysMenuService.findMenu();
    }

}
