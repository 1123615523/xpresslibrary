package com.aaa.service;/*
 */

import com.aaa.entity.Helpinfo;
import com.aaa.utils.PageModel;

public interface HelpService {

    //添加求助信息
    Integer addHelp(Helpinfo helpinfo,Integer cusid);

    //查询全部的求助信息
    PageModel<Helpinfo> findMenuPath(PageModel pm);

    //查询我发布的悬赏信息
    PageModel<Helpinfo> findUserInfo(PageModel pm);

}
