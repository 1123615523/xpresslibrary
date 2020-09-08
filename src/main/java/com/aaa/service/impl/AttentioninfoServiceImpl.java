package com.aaa.service.impl;

import com.aaa.dao.AttentioninfoDo;
import com.aaa.entity.Attentioninfo;
import com.aaa.entity.Customerinfo;
import com.aaa.service.AttentioninfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AttentioninfoServiceImpl implements AttentioninfoService {

    @Resource
    AttentioninfoDo attentioninfoDo;

    @Override
    public List<Customerinfo> findFenceCount(Integer cusid) {
        return attentioninfoDo.findFenceCount(cusid);
    }

    /**我的关注*/
    @Override
    public List<Map<String, Object>> MyAttention(Integer myid) {
        return attentioninfoDo.MyAttention(myid);
    }

    /**添加关注*/
    @Override
    public Integer addAttention(Attentioninfo attentioninfo) {
        return attentioninfoDo.addAttention(attentioninfo);
    }

    /**查询当前作者是否被关注*/
    @Override
    public Integer selectbyYM(Integer youid, Integer myid) {
        return attentioninfoDo.selectbyYM(youid,myid);
    }

    /**取消关注*/
    @Override
    public Integer delYM(Integer youid, Integer myid) {
        return attentioninfoDo.delYM(youid,myid);
    }
}
