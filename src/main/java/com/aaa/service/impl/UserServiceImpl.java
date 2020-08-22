package com.aaa.service.impl;/*
 */

import com.aaa.dao.UserDao;
import com.aaa.entity.SysUser;
import com.aaa.service.UserService;
import com.aaa.utils.PageModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王登科
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public PageModel<SysUser> findUserInfo(PageModel<SysUser> pm) {
        PageHelper.startPage(pm.getCurrentPage(),pm.getPageSize());
        List<SysUser> userInfo = userDao.findUserInfo();
        pm.setRows(userInfo);
        PageInfo<SysUser> personPageInfo = new PageInfo<SysUser>(userInfo);
        int pages = personPageInfo.getPages();
        long total = personPageInfo.getTotal();
        pm.setTotal(total);
        pm.setLastPage(pages);
        return pm;
    }
}
