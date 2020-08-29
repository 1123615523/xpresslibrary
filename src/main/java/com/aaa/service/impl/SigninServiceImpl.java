package com.aaa.service.impl;/*
 */

import com.aaa.dao.SigninDao;
import com.aaa.service.SigninService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class SigninServiceImpl implements SigninService {

    @Resource
    SigninDao signinDao;

    @Override
    public Map<String, Object> findSignInfo(Integer cusid) {
        HashMap<String, Object> map = new HashMap<>();
        //签到信息
        map.put("signinInfo",signinDao.findSigninInfo(cusid));
        //签到收益
        map.put("money",signinDao.findMoney(cusid));
        //签到次数
        map.put("count",signinDao.findCount(cusid));
        //最近签到时间
        map.put("time",signinDao.findTime(cusid));
        return map;
    }
}
