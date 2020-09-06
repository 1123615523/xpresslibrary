package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-09-04 19:46:25
 */
@Data
public class Orders  {

    private Integer id;
    
    private String ordered;
    
    private Date ordertime;
    
    private Double orderintegral;
    
    private Integer customerid;
    
    private Integer documented;

    private Documentation documentations;

}