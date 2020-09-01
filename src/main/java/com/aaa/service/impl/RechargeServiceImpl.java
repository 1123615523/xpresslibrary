package com.aaa.service.impl;/*
 */

import com.aaa.dao.RechargeDao;
import com.aaa.entity.Recharge;
import com.aaa.service.RechargeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王登科
 */

@Service
@Transactional
public class RechargeServiceImpl implements RechargeService {

    @Resource
    RechargeDao rechargeDao;

    @Override
    public Integer addRecharge(Recharge recharge) {
        return rechargeDao.addRecharge(recharge);
    }

    @Override
    public Map<String, Object> findRechargeInfo(Integer cusid) {
        HashMap<String, Object> map = new HashMap<>();
        //用户的消费记录
        map.put("rechargeinfo",rechargeDao.findRechargeInfo(cusid));
        //收入记录
        map.put("incomeInfo",rechargeDao.incomeInfo(cusid));
        //支出记录
        map.put("expenditureInfo",rechargeDao.expenditureInfo(cusid));
        //提现记录
        map.put("withdrawInfo",rechargeDao.withdrawInfo(cusid));
        return map;
    }
}
