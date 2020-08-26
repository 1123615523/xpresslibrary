package com.aaa.service;/*
 */

import com.aaa.entity.Resourcesinfo;

import java.util.List;

public interface ResourceService {

    //查询资源及资源下的详情
    List<Resourcesinfo> findResources();

}
