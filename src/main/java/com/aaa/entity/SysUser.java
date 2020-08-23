package com.aaa.entity;

import lombok.Data;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-08-20 20:07:32
 */
@Data
public class SysUser{
    
    private Integer id;
    
    private String name;
    
    private Integer sex;
    
    private String phone;
    
    private String address;
    
    private String idcard;
    
    private String email;
    
    private Integer state;
}