package com.aaa.service.impl;/*
 */

import com.aaa.dao.PermissionDao;
import com.aaa.entity.SysAccount;
import com.aaa.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 王登科
 */

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionDao permissionDao;


    @Override
    public List<String> findPathUrlByAccount(String account) {
        return permissionDao.findPathUrlByAccount(account);
    }

    @Override
    public List<String> findRoleByAccount(String account) {
        return permissionDao.findRoleByAccount(account);
    }

    @Override
    public SysAccount findByAccount(String account) {
        return permissionDao.findByAccount(account);
    }

    //查询可分配的权限
    @Override
    public List<Map<String, Object>> findPermission(Integer accountid) {
        List<Map<String, Object>> list = permissionDao.findParentId(accountid, 0);
        for(Map<String, Object> map : list){
            Integer pid = Integer.parseInt(map.get("id").toString());
            List<Map<String, Object>> res = permissionDao.findParentId(accountid, pid);
            map.put("child",res);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> findPermissionInfo() {
        //查询出的所有一级节点
        List<Map<String, Object>> list = permissionDao.findPermissionInfo(null);
        //查询出一级节点下的二级节点
        for(Map<String, Object> map : list){
            Integer menupid = Integer.parseInt(map.get("id").toString());
            List<Map<String, Object>> node = permissionDao.findPermissionInfo(menupid);
            map.put("children",node);
        }
        return list;
    }

    /**根据角色id查询所拥有权限*/
    @Override
    public List<Map<String, Object>> findByRoleId(Integer id) {
        return permissionDao.findByRoleId(id);
    }

}
