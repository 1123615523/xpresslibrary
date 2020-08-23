package com.aaa.service.impl;/*
 */

import com.aaa.dao.SysMenuPathDao;
import com.aaa.entity.SysMenuPath;
import com.aaa.service.SysMenuPathService;
import com.aaa.utils.PageModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class SysMenuPathServiceImpl implements SysMenuPathService {

    @Resource
    SysMenuPathDao sysMenuPathDao;

    @Override
    public Integer findMenuPathByUrl(Integer id,String pathurl) {
        SysMenuPath path = sysMenuPathDao.findMenuPathByUrl(id,pathurl);
        if(null == path){
            return 0;
        }
        return 1;
    }

    @Override
    public Integer updPath(SysMenuPath sysMenuPath) {
        return sysMenuPathDao.updPath(sysMenuPath);
    }

    @Override
    public Integer deletePath(Integer id) {
        return sysMenuPathDao.deletePath(id);
    }

    @Override
    public Integer addPath(SysMenuPath sysMenuPath) {
        return sysMenuPathDao.addPath(sysMenuPath);
    }

    @Override
    public PageModel<SysMenuPath> findMenuPath(PageModel pm) {
        PageHelper.startPage(pm.getCurrentPage(),pm.getPageSize());
        List<SysMenuPath> res = sysMenuPathDao.findSysMenu();
        pm.setRows(res);
        PageInfo<SysMenuPath> personPageInfo = new PageInfo<SysMenuPath>(res);
        int pages = personPageInfo.getPages();
        long total = personPageInfo.getTotal();
        pm.setTotal(total);
        pm.setLastPage(pages);
        return pm;
    }
}
