package com.aaa.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
public class SysAccount implements UserDetails {
    
    private Integer id;
    
    private String account;
    
    private String password;
    
    private Date createtime;
    
    private Integer enable;
    
    private Integer isaccountnonexpired;
    
    private Integer isaccountnonlocked;
    
    private Integer iscredentialsnonexpired;
    
    private Integer isenabled;

    private Collection<? extends GrantedAuthority> getAuthorities; //用户权限集合

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getAuthorities;
    }

    @Override
    public String getUsername() {
        return this.account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isaccountnonexpired==1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isaccountnonlocked==1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.iscredentialsnonexpired==1;
    }

    @Override
    public boolean isEnabled() {
        return this.isenabled==1;
    }
}