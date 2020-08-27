package com.aaa.service.impl;/*
 */

import com.aaa.dao.ResourceDao;
import com.aaa.entity.Resourcesdetails;
import com.aaa.entity.Resourcesinfo;
import com.aaa.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Resource
    ResourceDao resourceDao;

    @Override
    public List<Resourcesdetails> findResourceById(Integer resid) {
        return resourceDao.findResourceById(resid);
    }

    @Override
    public List<Resourcesinfo> findResources() {
        return resourceDao.findResources();
    }
}
