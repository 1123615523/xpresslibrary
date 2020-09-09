package com.aaa.service;

import com.aaa.entity.Customerinfo;
import com.aaa.entity.Documentation;
import com.aaa.utils.PageModel;

import java.util.List;

/**
 * @author 程亚辉
 */
public interface CustomerService {

    /**注册*/
    Integer add(Customerinfo customerinfo);

    /**登录*/
    Customerinfo bypwd(String customertel,String customeremail,String customerpwd);

    /*验证手机号是否重复*/
    Integer findCustomerByPhone(String phone);

    //修改用户的基本信息
    Integer updCustomer(Customerinfo customerinfo);

    //修改成功后刷新用户的session信息
    Customerinfo updLogin(Integer id);

    //修改用户的签名信息
    Integer updSignature(Integer id,String meno);

    //修改用户密码
    Integer updPassword(Integer id,String pwd);

    //充值成功修改用户余额
    Integer updMoney(Integer cusid,Double money);

    /**修改头像*/
    Integer editFile(Customerinfo customerinfo);


    /**根据用户id获取用户信息*/
    Customerinfo findbycid(Integer customerid);

    /**关注操作时，对关注量进行修改*/
    Integer updateattention(Integer customerfence,Integer youid);

    //查询个人信息主页的文档信息
    PageModel<Documentation> findUserInfo(PageModel pm);

    //查询个人粉丝数量倒叙显示
    List<Customerinfo> findFensiCount();

    //查询个人主页的信息
    Customerinfo findCustomerInfo(Integer cusid);

}
