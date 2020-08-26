package com.aaa.controller;

import com.aaa.service.SysRoleMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sysrolemenu")
public class SysRoleMenuController {

    @Resource
    SysRoleMenuService sysRoleMenuService;

    @RequestMapping(value = "EditSysRoleMenu",method = RequestMethod.PUT)
    public void EditSysRoleMenu(Integer id, int[] keys){
        sysRoleMenuService.del(id);
        for (int i = 0;i<keys.length;i++){
            sysRoleMenuService.add(id,keys[i]);
        }
    }
}
