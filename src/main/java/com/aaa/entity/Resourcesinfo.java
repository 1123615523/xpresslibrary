package com.aaa.entity;

import lombok.Data;

import java.util.List;

/**
 * (Resourcesinfo)实体类
 *
 * @author makejava
 * @since 2020-08-26 15:36:14
 */
@Data
public class Resourcesinfo{
    
    private Integer id;
    
    private String name;

    private List<Resourcesdetails> resourcesdetails;

}