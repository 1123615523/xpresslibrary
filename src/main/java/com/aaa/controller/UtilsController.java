package com.aaa.controller;/*
 */

import com.aaa.service.PermissionService;
import com.aaa.utils.JwtUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @RequestMapping("find")
    public Object find(String token){
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        List<Map<String, Object>> list = permissionService.findPermission(Integer.parseInt(id));
        return list;
    }
}
