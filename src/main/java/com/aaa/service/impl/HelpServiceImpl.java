package com.aaa.service.impl;/*
 */

import com.aaa.dao.CustomerDao;
import com.aaa.dao.HelpDao;
import com.aaa.dao.RechargeDao;
import com.aaa.entity.Customerinfo;
import com.aaa.entity.Helpinfo;
import com.aaa.entity.Recharge;
import com.aaa.service.HelpService;
import com.aaa.utils.PageModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HelpServiceImpl implements HelpService {

    @Resource
    HelpDao helpDao;

    @Resource
    CustomerDao customerDao;

    @Resource
    RechargeDao rechargeDao;

    @Override
    public PageModel<Helpinfo> findUserInfo(PageModel pm) {
        PageHelper.startPage(pm.getCurrentPage(),pm.getPageSize());
        String string = pm.getKeyWord().toString();
        int cusid = Integer.parseInt(string);
        List<Helpinfo> helpInfo = helpDao.findUserInfo(cusid);
        pm.setRows(helpInfo);
        PageInfo<Helpinfo> personPageInfo = new PageInfo<Helpinfo>(helpInfo);
        int pages = personPageInfo.getPages();
        long total = personPageInfo.getTotal();
        pm.setTotal(total);
        pm.setLastPage(pages);
        return pm;
    }

    @Override
    public PageModel<Helpinfo> findMenuPath(PageModel pm) {
        PageHelper.startPage(pm.getCurrentPage(),pm.getPageSize());
        List<Helpinfo> helpInfo = helpDao.findHelpInfo();
        pm.setRows(helpInfo);
        PageInfo<Helpinfo> personPageInfo = new PageInfo<Helpinfo>(helpInfo);
        int pages = personPageInfo.getPages();
        long total = personPageInfo.getTotal();
        pm.setTotal(total);
        pm.setLastPage(pages);
        return pm;
    }

    @Override
    public Integer addHelp(Helpinfo helpinfo, Integer cusid) {
        helpinfo.setCid(cusid);
        helpinfo.setHelptime(new Date());
        helpinfo.setHelpcount(0);
        helpinfo.setHelpcomment(0);
        helpinfo.setHelpstatus(0);
        //录入求助信息
        Integer res = helpDao.addHelp(helpinfo);
        if(res > 0){
            //修改用户金额-悬赏金额
            Customerinfo customerinfo = customerDao.updLogin(cusid);
            double resMoney = customerinfo.getCustomermoney() - helpinfo.getHelpintegral();
            Integer result = customerDao.updMoney(cusid, resMoney);
            if(result > 0){
                //修改成功生成消费记录
                Recharge recharge = new Recharge();
                recharge.setRechargetime(new Date());
                recharge.setRechargemoney(helpinfo.getHelpintegral()); //金额
                recharge.setPaytype(0); //支付类型
                recharge.setRechargeaccount(customerinfo.getCustomertel());
                recharge.setCustomerid(cusid); //支付人
                recharge.setRechargetype(5); //发布悬赏
                Integer addRecharge = rechargeDao.addRecharge(recharge);
                if(addRecharge > 0){
                    return 2;
                }
                return 0;
            }
        }
        return 0;
    }
}
