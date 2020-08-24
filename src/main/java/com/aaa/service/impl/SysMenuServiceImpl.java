package com.aaa.service.impl;/*
 */

import com.aaa.dao.SysMenuDao;
import com.aaa.entity.SysMenu;
import com.aaa.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    SysMenuDao sysMenuDao;

    @Override
    public Integer updMenu(SysMenu sysMenu) {
        return sysMenuDao.updMenu(sysMenu);
    }

    @Override
    public SysMenu findMenuById(SysMenu sysMenu) {
        return sysMenuDao.findMenuById(sysMenu);
    }

    @Override
    public List<SysMenu> findMenu() {
        return sysMenuDao.findMenu();
    }
}
