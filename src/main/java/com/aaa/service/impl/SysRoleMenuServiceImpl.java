package com.aaa.service.impl;

import com.aaa.dao.SysRoleMenuDao;
import com.aaa.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Resource
    SysRoleMenuDao sysRoleMenuDao;

    @Override
    public Integer add(Integer rid, Integer pid) {
        return sysRoleMenuDao.add(rid,pid);
    }

    @Override
    public Integer del(Integer rid) {
        return sysRoleMenuDao.del(rid);
    }
}
