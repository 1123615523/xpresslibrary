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
}
