package com.aaa.service.impl;

import com.aaa.dao.SysRoleDao;
import com.aaa.entity.SysRole;
import com.aaa.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAll() {
        return sysRoleDao.findAll();
    }
}
