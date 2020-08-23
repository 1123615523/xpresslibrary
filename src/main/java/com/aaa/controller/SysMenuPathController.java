package com.aaa.controller;/*
 */

import com.aaa.entity.SysMenuPath;
import com.aaa.service.SysMenuPathService;
import com.aaa.utils.PageModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王登科
 */

@RestController
@RequestMapping("path")
public class SysMenuPathController {

    @Resource
    SysMenuPathService sysMenuPathService;

    //修改资源并且重复验证
    @RequestMapping("updPath")
    public Integer updPath(@RequestBody SysMenuPath sysMenuPath){
        Integer path = sysMenuPathService.findMenuPathByUrl(sysMenuPath.getId(),sysMenuPath.getPathurl());
        if(path == 0){
            return sysMenuPathService.updPath(sysMenuPath);
        }
        return 2;
    }

    //删除资源
    @RequestMapping("deletePath")
    public Integer deletePath(Integer id){
        return sysMenuPathService.deletePath(id);
    }

    //添加资源
    @RequestMapping("addPath")
    public Integer addPath(@RequestBody SysMenuPath sysMenuPath){
        return sysMenuPathService.addPath(sysMenuPath);
    }

    //查询资源路径
    @RequestMapping("findMenuPath")
    public Object findMenuPath(PageModel<SysMenuPath> pm){
        pm = sysMenuPathService.findMenuPath(pm);
        return pm;
    }

}
