package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysMenuPath)实体类
 *
 * @author makejava
 * @since 2020-08-20 20:07:08
 */
@Data
public class SysMenuPath{
    
    private Integer id;
    
    private String pathurl;
    
    private String meno;
    
    private Integer menuid;

}