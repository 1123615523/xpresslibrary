package com.aaa.service;/*
 */

import com.aaa.entity.Resourcesdetails;
import com.aaa.entity.Resourcesinfo;

import java.util.List;

public interface ResourceService {

    //查询资源及资源下的详情
    List<Resourcesinfo> findResources();

    //根据资源ID查询资源详情
    List<Resourcesdetails> findResourceById(Integer resid);

}
