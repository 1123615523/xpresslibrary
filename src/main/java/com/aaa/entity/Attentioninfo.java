package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * (Attentioninfo)实体类
 *关注表
 * @author makejava
 * @since 2020-09-05 14:27:54
 */
@Data
public class Attentioninfo  {

    private Integer aid;
    
    private Date attentiontime;
    
    private Integer youid;
    
    private Integer myid;

}