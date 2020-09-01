package com.aaa.dao;

import com.aaa.entity.Documentation;

import java.util.List;
import java.util.Map;

public interface DocumentationDao {

    /**上传文件添加方法*/
    Integer add(Documentation documentation);

    /**今日特别推荐查询方法*/
    List<Documentation> documentationespecially();

    /**根据文档id值进行查询文档详细信息*/
    Map<String,Object> bydid(Integer did);

    /**根据用户自己的id获取自己的所有文档信息*/
    List<Documentation> findbyid(Integer authored);

    /**根据文档id获取文档信息*/
    Documentation findbydid(Integer did);
}