package com.aaa.dao;/*
 */

import com.aaa.entity.Helpinfo;

import java.util.List;

public interface HelpDao {

    //添加求助信息
    Integer addHelp(Helpinfo helpinfo);

    //查询发布的悬赏信息
    List<Helpinfo> findHelpInfo();

    //查询发布的求助的详细信息
    Helpinfo findHelp(Integer helpid);

    //查询我发布的悬赏信息
    List<Helpinfo> findUserInfo(Integer cusid);

    //修改求助的状态
    Integer updHelpStatus(Integer helpid);

    //修改帖子的评论量
    Integer updComment(Integer helpid,Integer commend);

}
