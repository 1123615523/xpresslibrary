package com.aaa.service;/*
 */

import com.aaa.entity.SysMenuPath;
import com.aaa.utils.PageModel;

public interface SysMenuPathService {

    PageModel<SysMenuPath> findMenuPath(PageModel pm);

    //添加资源路径
    Integer addPath(SysMenuPath sysMenuPath);

    //删除资源路径
    Integer deletePath(Integer id);

    //查询资源是否重复
    Integer findMenuPathByUrl(Integer id,String pathurl);

    //修改资源
    Integer updPath(SysMenuPath sysMenuPath);

}
