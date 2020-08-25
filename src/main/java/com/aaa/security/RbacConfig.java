package com.aaa.security;/*
 */

import com.aaa.entity.SysAccount;
import com.aaa.service.PermissionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacConfig")
public class RbacConfig {


    @Resource
    PermissionService permissionService;


    public boolean isForbidden(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        String requestURI = request.getRequestURI();
        if("/favicon.ico".equals(requestURI)){
            return true;
        }
        if(principal instanceof UserDetails){
            SysAccount sysAccount = (SysAccount)authentication.getPrincipal();
            List<String> DatabaseUrl = permissionService.findPathUrlByAccount(sysAccount.getAccount());
            for(String url : DatabaseUrl){
                if(url.equals(request.getRequestURI())){
                    return true;
                }
            }
        }
        return false;
    }

}
