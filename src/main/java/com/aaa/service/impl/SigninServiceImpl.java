package com.aaa.service.impl;/*
 */

import com.aaa.dao.CustomerDao;
import com.aaa.dao.RechargeDao;
import com.aaa.dao.SigninDao;
import com.aaa.entity.Customerinfo;
import com.aaa.entity.Recharge;
import com.aaa.entity.Signin;
import com.aaa.service.SigninService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class SigninServiceImpl implements SigninService {

    @Resource
    SigninDao signinDao;

    @Resource
    CustomerDao customerDao;

    @Resource
    RechargeDao rechargeDao;

    @Override
    public Integer signinStatus(Integer resid)  {
        SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd" );
        try {
            //现在时间
            String str = sdf.format(new Date());
            //用户最后一次签到时间
            Date time = signinDao.findTime(resid);
           //这里会出意外
            String str2 = sdf.format(time);
            //做转换以比较
            Date res = sdf.parse(str);
            Date res2 = sdf.parse(str2);
            if(res.getTime() == res2.getTime()){
                //今天已经签到过了
                return 1;
            }else if(res.getTime() > res2.getTime()){
                //能够签到
                Customerinfo customerinfo = customerDao.updLogin(resid);
                //签到后积分+1
                double mon = customerinfo.getCustomermoney() + 1;
                Integer integer = customerDao.updMoney(resid, mon);
                if(integer > 0){
                    //生成签到记录
                    Signin signin = new Signin();
                    signin.setCustomerid(resid);
                    signin.setIncome(1.00);
                    signin.setIncometime(new Date());
                    Integer addSignin = signinDao.addSignin(signin);
                    if(addSignin > 0){
                        //录入消费明细
                        Recharge recharge = new Recharge();
                        recharge.setRechargetime(new Date());
                        recharge.setRechargemoney(1.00);
                        recharge.setPaytype(1);
                        recharge.setRechargeaccount(customerinfo.getCustomertel());
                        recharge.setCustomerid(resid);
                        recharge.setRechargetype(1); //签到
                        Integer addRecharge = rechargeDao.addRecharge(recharge);
                        if(addRecharge > 0){
                            return 2;
                        }
                        return 0;
                    }
                    return 0;
                }
                return 0;
            }else{
                //签到出错
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

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
