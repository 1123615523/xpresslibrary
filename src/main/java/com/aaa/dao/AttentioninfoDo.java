package com.aaa.dao;

import com.aaa.entity.Attentioninfo;

public interface AttentioninfoDo {

    /**添加关注*/
    Integer addAttention(Attentioninfo attentioninfo);

    /**查询当前作者是否被关注*/
    Integer selectbyYM(Integer youid,Integer myid);

    /**取消关注*/
    Integer delYM(Integer youid,Integer myid);
}
