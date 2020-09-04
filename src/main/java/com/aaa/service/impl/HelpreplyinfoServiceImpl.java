package com.aaa.service.impl;/*
 */

import com.aaa.dao.CustomerDao;
import com.aaa.dao.HelpDao;
import com.aaa.dao.HelpreplyinfoDao;
import com.aaa.dao.RechargeDao;
import com.aaa.entity.Customerinfo;
import com.aaa.entity.Helpinfo;
import com.aaa.entity.Helpreplyinfo;
import com.aaa.entity.Recharge;
import com.aaa.service.HelpreplyinfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HelpreplyinfoServiceImpl implements HelpreplyinfoService {

    @Resource
    HelpDao helpDao;

    @Resource
    HelpreplyinfoDao helpreplyinfoDao;

    @Resource
    CustomerDao customerDao;

    @Resource
    RechargeDao rechargeDao;

    /**
     * @param helpid  原帖ID
     * @param replyid 回复贴ID
     * @param money   悬赏金额
     * @param cusid   客户ID
     * @return
     */
    @Override
    public Integer updHelpInfo(Integer helpid, Integer replyid, Double money, Integer cusid) {
        Integer help = helpDao.updHelpStatus(helpid); //修改求助表状态：已解决\
        Integer reply = helpreplyinfoDao.updHelpReply(replyid); //修改评论为：已采纳
        if (help > 0 && reply > 0) {
            Customerinfo customerinfo = customerDao.updLogin(cusid);
            double res = customerinfo.getCustomermoney() + money; //修改客户原有金额：获奖
            Integer upd = customerDao.updMoney(cusid, res);
            if (upd > 0) {
                //生成账户流水记录
                Recharge recharge = new Recharge();
                recharge.setRechargetime(new Date());
                recharge.setRechargemoney(money);
                recharge.setPaytype(1);
                recharge.setRechargeaccount(customerinfo.getCustomertel());
                recharge.setCustomerid(customerinfo.getCustomerid());
                recharge.setRechargetype(6);
                Integer rechargeRes = rechargeDao.addRecharge(recharge);
                if (rechargeRes > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public List<Helpreplyinfo> findHelpReplyInfo(Integer helpid) {
        return helpreplyinfoDao.findHelpReplyInfo(helpid);
    }

    @Override
    public Integer delHelpInfo(Integer id,Integer helpid) {
        Integer parentId = helpreplyinfoDao.findParentId(id);
        if (parentId == 0) {
            Integer child = helpreplyinfoDao.delHelpInfo(id, id);
            Helpinfo help = helpDao.findHelp(helpid);
            int resComment = help.getHelpcomment() - child;
            Integer comment = helpDao.updComment(helpid, resComment);
            return child;
        }
        Integer parent = helpreplyinfoDao.delHelpInfo(id, null);
        Helpinfo help = helpDao.findHelp(helpid);
        int resComment = help.getHelpcomment() - parent;
        Integer comment = helpDao.updComment(helpid, resComment);
        return parent;
    }

    @Override
    public Integer addHhelp(String content, Integer cusid, Integer helpid, Integer parent) {
        if (parent == 0) {
            //录入父级楼层评论
            Helpreplyinfo helpreplyinfo = new Helpreplyinfo();
            helpreplyinfo.setReplycontent(content);
            helpreplyinfo.setReplytime(new Date());
            helpreplyinfo.setCustomerhelpid(cusid);
            helpreplyinfo.setHelpid(helpid);
            helpreplyinfo.setReplystatus(0);
            helpreplyinfo.setReplycount(0);
            helpreplyinfo.setReplyparentid(0);
            Integer res = helpreplyinfoDao.addHhelp(helpreplyinfo);
            //修改评论量
            Helpinfo help = helpDao.findHelp(helpid);
            int resComment = help.getHelpcomment() + 1;
            Integer comment = helpDao.updComment(helpid, resComment);

            if (res > 0) {
                return 1;
            }
        } else {
            //录入子级楼层评论
            Helpreplyinfo helpreplyinfo = new Helpreplyinfo();
            helpreplyinfo.setReplycontent(content);
            helpreplyinfo.setReplytime(new Date());
            helpreplyinfo.setCustomerhelpid(cusid);
            helpreplyinfo.setHelpid(helpid);
            helpreplyinfo.setReplystatus(0);
            helpreplyinfo.setReplycount(0);
            helpreplyinfo.setReplyparentid(parent);
            Integer res = helpreplyinfoDao.addHhelp(helpreplyinfo);
            //修改评论量
            Helpinfo help = helpDao.findHelp(helpid);
            int resComment = help.getHelpcomment() + 1;
            Integer comment = helpDao.updComment(helpid, resComment);
            if (res > 0) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Helpinfo findHelp(Integer helpid) {
        return helpDao.findHelp(helpid);
    }

    @Override
    public List<Map<String, Object>> findHelpInfo(Integer helpid) {
        List<Map<String, Object>> helpInfo = helpreplyinfoDao.findHelpInfo(helpid, 0);
        for (Map<String, Object> map : helpInfo) {
            Integer replyparentid = Integer.parseInt(map.get("id").toString());
            List<Map<String, Object>> node = helpreplyinfoDao.findHelpInfo(helpid, replyparentid);
            map.put("child", node);
        }
        return helpInfo;
    }
}
