package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * (Helpreplyinfo)实体类
 *
 * @author makejava
 * @since 2020-09-02 15:37:14
 */
@Data
public class Helpreplyinfo{
    
    private Integer id;
    
    private String replycontent;
    
    private Date replytime;
    
    private Integer customerhelpid;
    
    private Integer replystatus;
    
    private Integer helpid;
    
    private Integer replyparentid;

    private Customerinfo customerinfos;

    private Integer replycount;

}