package com.aaa.controller;

import com.aaa.service.SysRoleMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
