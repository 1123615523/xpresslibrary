package com.aaa.entity;

import lombok.Data;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2020-08-20 20:06:58
 */
@Data
public class SysMenu{
    
    private Integer id;
    
    private Integer menupid;

    private String childid;
    
    private String menuname;
    
    private String path;
    
    private String routename;
    
    private String componentname;
    
    private String icon;

}