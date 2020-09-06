package com.aaa.service.impl;

import com.aaa.dao.CustomerDao;
import com.aaa.dao.DocumentationDao;
import com.aaa.dao.OrdersDao;
import com.aaa.dao.RechargeDao;
import com.aaa.entity.Customerinfo;
import com.aaa.entity.Orders;
import com.aaa.entity.Recharge;
import com.aaa.service.OrdersService;
import com.aaa.utils.PageModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrdersService {

    @Resource
    OrdersDao orderDao;

    @Resource
    DocumentationDao documentationDao;

    @Resource
    RechargeDao rechargeDao;

    @Resource
    CustomerDao customerDao;

    @Override
    public Integer addOrder(Orders orders) {
        return orderDao.documentbuy(orders);
    }

    @Override
    public PageModel<Orders> findOrderInfo(PageModel<Orders> pm) {
        PageHelper.startPage(pm.getCurrentPage(),pm.getPageSize());
        String string = pm.getKeyWord().toString();
        int cusid = Integer.parseInt(string);
        List<Orders> orderInfo = orderDao.findOrderInfo(cusid);
        pm.setRows(orderInfo);
        PageInfo<Orders> pageInfo = new PageInfo<>(orderInfo);
        int pages = pageInfo.getPages();
        long total = pageInfo.getTotal();
        pm.setTotal(total);
        pm.setLastPage(pages);
        return pm;
    }

    /**购买方法
     * 该方法中进行消费记录，赚取记录，订单生成等信息
     * */
    @Override
    public Integer documentbuy(Integer did, HttpSession session) {
        //获取当前用户
        Customerinfo cus = (Customerinfo) session.getAttribute("cus");
        //获取当前用户id
        Integer customerid = cus.getCustomerid();
        //获取当前用户的账号
        String custel = cus.getCustomertel();
        //获取当前用户的积分
        Double customermoney = cus.getCustomermoney();
        //根据文档did获取详细信息
        Map<String, Object> findbydidcid = documentationDao.findbydidcid(did);
        //获取作者的积分
        Double producermoney = (Double) findbydidcid.get("customermoney");
        //获取文档积分
        int sellingprice = (int) findbydidcid.get("sellingprice");
        double res = (double) sellingprice;
        //获取账号
        String customertel = (String) findbydidcid.get("customertel");
        Integer producerid = (Integer) findbydidcid.get("customerid");
        //当前用户减去文档钱
        Double money1 = customermoney - sellingprice;
        //修改当前用户金额-
        Integer one = customerDao.updMoney(customerid, money1);
        //生成消费记录 消费时间 消费积分 消费类型 消费账号 消费id 项目类别 文档id
        Recharge recharge = new Recharge();
        recharge.setRechargetime(new Date());
        recharge.setRechargemoney(sellingprice);
        recharge.setPaytype(0);
        recharge.setRechargeaccount(custel);
        recharge.setCustomerid(customerid);
        recharge.setRechargetype(4);
        recharge.setDocumentid(did);
        Integer two = rechargeDao.recording(recharge);
        //作者获取文档钱
        Double money2 = producermoney + sellingprice;
        //修改作者金额+
        Integer there = customerDao.updMoney(producerid, money2);
        //生成赚取记录  赚取时间 赚取积分 消费类型 赚取账号 赚取id 项目类别 文档id
        Recharge producer = new Recharge();
        producer.setRechargetime(new Date());
        producer.setRechargemoney(sellingprice);
        producer.setPaytype(1);
        producer.setRechargeaccount(customertel);
        producer.setCustomerid(producerid);
        producer.setRechargetype(7);
        producer.setDocumentid(did);
        Integer four = rechargeDao.recording(producer);
        //生成订单：随机生成订单编号 当前日期 文档积分 消费者id 文档id
        //生成订单编号
        long time = new Date().getTime();
        String orderId = String.valueOf(time);
        Orders order = new Orders();
        order.setOrdered(orderId);
        order.setOrdertime(new Date());
        order.setOrderintegral(res);
        order.setCustomerid(customerid);
        order.setDocumented(did);
        Integer five = orderDao.documentbuy(order);
        if(one > 0 && two > 0 && there > 0 && four > 0 && five > 0){
            return 1;
        }
        return 0;
    }
}
