package com.aaa.service;/*
 */

import com.aaa.entity.Helpinfo;
import com.aaa.entity.Helpreplyinfo;

import java.util.List;
import java.util.Map;

public interface HelpreplyinfoService {

    //查询评论页面
    Helpinfo findHelp(Integer helpid);

    //查询评论的详情
    List<Map<String,Object>> findHelpInfo(Integer helpid);

    //添加求助回复信息
    Integer addHhelp(String content,Integer cusid,Integer helpid,Integer parent);

    //删除评论
    Integer delHelpInfo(Integer id,Integer helpid);

    //查看求助信息下的详细评论进行审核
    List<Helpreplyinfo> findHelpReplyInfo(Integer helpid);

    //修改求助的状态，以及给别人发钱
    Integer updHelpInfo(Integer helpid,Integer replyid,Double money,Integer cusid);

}
