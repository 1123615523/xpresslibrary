package com.aaa.dao;/*
 */

import com.aaa.entity.Helpreplyinfo;

import java.util.List;
import java.util.Map;

/**
 * @author 王登科
 */

public interface HelpreplyinfoDao {

    //查询评论以及评论下的盖楼详情
    List<Map<String,Object>> findHelpInfo(Integer helpid, Integer replyparentid);

    //添加求助回复信息
    Integer addHhelp(Helpreplyinfo helpreplyinfo);

    //查询父级楼层ID
    Integer findParentId(Integer id);

    //删除评论：父级/子级
    Integer delHelpInfo(Integer id,Integer parentId);

    //查看求助信息下的详细评论进行审核
    List<Helpreplyinfo> findHelpReplyInfo(Integer helpid);

    //修改帖子状态已解决
    Integer updHelpReply(Integer replyid);

}
