package com.aaa.dao;/*
 */

import com.aaa.entity.Helpinfo;

import java.util.List;

public interface HelpDao {

    //添加求助信息
    Integer addHelp(Helpinfo helpinfo);

    //查询发布的悬赏信息
    List<Helpinfo> findHelpInfo();

}
