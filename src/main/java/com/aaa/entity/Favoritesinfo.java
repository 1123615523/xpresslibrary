package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * (Favoritesinfo)实体类
 *
 * @author makejava
 * @since 2020-09-05 09:42:00
 */
@Data
public class Favoritesinfo  {
    
    
    private Integer id;
    
    private Date favoritetime;
    
    private Integer documentationid;
    
    private Integer customerid;
}