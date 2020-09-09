package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * (Recharge)实体类
 *
 * @author makejava
 * @since 2020-08-31 09:11:49
 */
@Data
public class Recharge{
    
    private Integer id;
    
    private String rechargeid;
    
    private Date rechargetime;
    
    private double rechargemoney;
    
    private Integer paytype;
    
    private String rechargeaccount;
    
    private Integer customerid;

    private Integer rechargetype;

    private Integer documentid;

    //相关文档
    private Documentation documentations;

    //充值人
    private Customerinfo customerinfos;

}