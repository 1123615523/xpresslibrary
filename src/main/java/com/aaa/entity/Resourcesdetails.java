package com.aaa.entity;

import lombok.Data;

/**
 * (Resourcesdetails)实体类
 *
 * @author makejava
 * @since 2020-08-26 15:36:27
 */
@Data
public class Resourcesdetails{
    
    private Integer did;
    
    private String dname;
    
    private Integer resourcesid;

    private Resourcesinfo resourcesinfos;

}