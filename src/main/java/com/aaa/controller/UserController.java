package com.aaa.controller;/*
 */

import com.aaa.entity.SysUser;
import com.aaa.service.UserService;
import com.aaa.utils.PageModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王登科
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("findUserInfo")
    public Object findUserInfo(PageModel<SysUser> pm){
        pm = userService.findUserInfo(pm);
        return pm;
    }
}
