package com.aaa.dao;

import com.aaa.entity.Documentation;

import java.util.List;
import java.util.Map;

public interface DocumentationDao {

    /**上传文件添加方法*/
    Integer add(Documentation documentation);

    /**今日特别推荐查询方法*/
    List<Documentation> documentationespecially();

    /**最近上传查询方法*/
    List<Documentation> documentationlatest();

    /**根据文档id值进行查询文档详细信息*/
    Map<String,Object> bydid(Integer did);

    /**根据用户自己的id获取自己的所有文档信息*/
    List<Documentation> findbyid(Integer authored);

    /**根据文档id获取文档信息*/
    Documentation findbydid(Integer did);

    /**根据ppt格式进行查询随机14条数据*/
    List<Documentation> documentationppt();

    /**根据用户个人上传的文档数量查询牛人榜*/
    List<Map<String,Object>> findbull();

    //根据资源ID查询资源
    List<Documentation> findDocumentByDetaisid(Integer detaisid);

    //查询最新更新的资源
    List<Documentation> findNewDocument(Integer did);


    /**根据文档id查询当前文档信息和作者详细信息*/
    Map<String,Object> findbydidcid(Integer did);

    /**收藏操作时，对收藏量进行修改*/
    Integer updatefavorites(Integer favorites,Integer did);
}
