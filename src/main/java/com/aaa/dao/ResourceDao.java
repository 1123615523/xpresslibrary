package com.aaa.dao;/*
 */

import com.aaa.entity.Resourcesinfo;

import java.util.List;

public interface ResourceDao {

    //查询资源及资源下的详情
    List<Resourcesinfo> findResources();

}
