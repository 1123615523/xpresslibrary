package com.aaa.controller;/*
 */

import com.aaa.entity.SysUser;
import com.aaa.service.AccountService;
import com.aaa.service.PermissionService;
import com.aaa.service.UserService;
import com.aaa.utils.JwtUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 王登科
 */
@RequestMapping("utils")
@RestController
public class UtilsController {

    @Resource
    PermissionService permissionService;

    @Resource
    AccountService accountService;

    @Resource
    UserService userService;

    @RequestMapping("find")
    public Object find(String token){
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        List<Map<String, Object>> list = permissionService.findPermission(Integer.parseInt(id));
        return list;
    }

    @RequestMapping("person")
    public Object person(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        SysUser byId = accountService.findById(Integer.parseInt(id));
        return byId;
    }

    @RequestMapping("editperson")
    public Integer editperson(@RequestBody SysUser sysUser){
        sysUser.setState(1);
        Integer update = userService.update(sysUser);
        return update;
    }
}
