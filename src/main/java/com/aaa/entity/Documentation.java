package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/**
 * (Documentation)实体类
 *
 * @author makejava
 * @since 2020-08-29 17:56:54
 */
@Data
public class Documentation  {

    private Integer did;

    private String filename;

    private String title;

    private String essentialcode;

    private Integer detaisid;

    private String introduction;

    private Integer previewpage;

    private Integer pages;

    private Integer allowdownload;

    private Integer original;

    private Integer sellingprice;

    private Date releasetime;

    private Integer downloads;

    private Integer pageviews;

    private Integer favorites;

    private String documentpath;

    private Float documentsize;

    private String documentformat;

    private Integer documentstatus;

    private String filepath;

    private String imgsname;

    private Integer authored;

    //文档作者
    private Customerinfo customerinfos;

}