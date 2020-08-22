package com.aaa.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-08-20 20:07:16
 */
@Data
public class SysRole{
    
    private Integer id;
    
    private String rolename;
    
    private String roledesc;
    
    private String rolecode;
    
    private Integer status;
    
    private Date createtime;

}