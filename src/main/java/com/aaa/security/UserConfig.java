package com.aaa.security;/*
 */


import com.aaa.entity.SysAccount;
import com.aaa.service.PermissionService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class UserConfig implements UserDetailsService {


    @Resource
    PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        SysAccount sysAccount = permissionService.findByAccount(account);
        if(null == account){
            throw new UsernameNotFoundException("账号不存在");
        }

        //查询角色信息
        List<String> roleByAccount = permissionService.findRoleByAccount(account);

        //查询权限信息
        List<String> authorities  = permissionService.findPathUrlByAccount(account);

        //角色也添进去
        authorities.addAll(roleByAccount);

        //权限分给实体类
        sysAccount.setGetAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList(
                        ////List转字符串,逗号分隔
                        String.join(",",authorities)
                )
        );

        return sysAccount;
    }
}
