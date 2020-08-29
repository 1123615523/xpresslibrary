package com.aaa.service;/*
 */

import java.util.Map;

public interface SigninService {

    //登录后查询自己的签到信息
   Map<String,Object> findSignInfo(Integer cusid);

}
