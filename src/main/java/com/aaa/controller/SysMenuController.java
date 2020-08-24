package com.aaa.controller;/*
 */

import com.aaa.entity.SysMenu;
import com.aaa.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("updMenu")
    public Object updMenu(@RequestBody SysMenu sysMenu){
        SysMenu res = sysMenuService.findMenuById(sysMenu);
        if(null == res){
            Integer upd = sysMenuService.updMenu(sysMenu);
            if(upd > 0){
                return 1;
            }
            return 0;
        }
        return 2;
    }

}
