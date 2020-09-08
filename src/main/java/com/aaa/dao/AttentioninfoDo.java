package com.aaa.dao;

import com.aaa.entity.Attentioninfo;
import com.aaa.entity.Customerinfo;

import java.util.List;
import java.util.Map;

public interface AttentioninfoDo {

    /**添加关注*/
    Integer addAttention(Attentioninfo attentioninfo);

    /**查询当前作者是否被关注*/
    Integer selectbyYM(Integer youid,Integer myid);

    /**取消关注*/
    Integer delYM(Integer youid,Integer myid);

    //查询该作者被那些人关注了
    List<Customerinfo> findFenceCount(Integer cusid);

    /**我的关注*/
    List<Map<String,Object>> MyAttention(Integer myid);
}
