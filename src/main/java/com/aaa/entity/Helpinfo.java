package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * (Helpinfo)实体类
 *
 * @author makejava
 * @since 2020-08-31 16:30:58
 */
@Data
public class Helpinfo{
    
    private Integer id;
    
    private Date helptime;
    
    private String helpcontent;
    
    private Integer cid;
    
    private double helpintegral;
    
    private Integer helpcount;
    
    private Integer helpcomment;
    
    private Integer helpstatus;
    
    private Integer helptype;

    private String helptitle;

    private Customerinfo customerinfos;

}