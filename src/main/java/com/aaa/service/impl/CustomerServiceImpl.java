package com.aaa.service.impl;

import com.aaa.dao.CustomerDao;
import com.aaa.dao.DocumentationDao;
import com.aaa.entity.Customerinfo;
import com.aaa.entity.Documentation;
import com.aaa.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao customerDao;

    @Resource
    DocumentationDao documentationDao;

    @Override
    public List<Customerinfo> findFensiCount() {
        return customerDao.findFensiCount();
    }

    /**根据用户id获取用户信息*/
    @Override
    public Customerinfo findbycid(Integer customerid) {
        return customerDao.findbycid(customerid);
    }


    /**关注操作时，对关注量进行修改*/
    @Override
    public Integer updateattention(Integer customerfence, Integer youid) {
        return customerDao.updateattention(customerfence,youid);
    }

    @Override
    public Map<String, Object> findUserInfo(Integer cusid) {
        HashMap<String, Object> map = new HashMap<>();
        Customerinfo customerinfo = customerDao.updLogin(cusid);
        map.put("customerinfo",customerinfo);
        List<Documentation> documentations = documentationDao.findbyid(cusid);
        map.put("documentations",documentations);
        return map;
    }

    @Override
    public Integer updMoney(Integer cusid, Double money) {
        return customerDao.updMoney(cusid,money);
    }

    /**修改头像*/
    @Override
    public Integer editFile(Customerinfo customerinfo) {
        return customerDao.editFile(customerinfo);
    }

    @Override
    public Integer updPassword(Integer id, String pwd) {
        return customerDao.updPassword(id,pwd);
    }

    @Override
    public Integer updSignature(Integer id, String meno) {
        return customerDao.updSignature(id,meno);
    }

    @Override
    public Customerinfo updLogin(Integer id) {
        return customerDao.updLogin(id);
    }

    @Override
    public Integer updCustomer(Customerinfo customerinfo) {
        return customerDao.updCustomer(customerinfo);
    }

    @Override
    public Integer findCustomerByPhone(String phone) {
        Customerinfo customerByPhone = customerDao.findCustomerByPhone(phone);
        if(null != customerByPhone){
            return 1;
        }
        return 0;
    }

    @Override
    public Integer add(Customerinfo customerinfo) {
        return customerDao.add(customerinfo);
    }

    @Override
    public Customerinfo bypwd(String customertel, String customeremail, String customerpwd) {
        return customerDao.bypwd(customertel,customeremail,customerpwd);
    }
}
