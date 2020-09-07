package com.aaa.frontcontroller;

import com.aaa.entity.Attentioninfo;
import com.aaa.entity.Customerinfo;
import com.aaa.service.AttentioninfoService;
import com.aaa.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("attention")
public class AttentioninfoController {

    @Resource
    AttentioninfoService attentioninfoService;

    @Resource
    CustomerService customerService;

    @RequestMapping("findFenceInfo")
    public Object findFenceInfo(Integer cusid){
        return attentioninfoService.findFenceCount(cusid);
    }

    /**添加关注*/
    @RequestMapping("addAttention")
    public Object addAttention(Integer youid, Integer myid){
        System.out.println("youid"+youid);
        System.out.println("myid"+myid);

        //获取当前作者信息
        Customerinfo findbycid = customerService.findbycid(youid);
        Integer customerid = findbycid.getCustomerid();
        System.out.println("作者"+customerid);
        //获取当前作者的关注量
        Integer fence = findbycid.getCustomerfence();
        int count = fence+1;
        //修改当前作者的关注量
        Integer updateattention = customerService.updateattention(count, youid);
        System.out.println("修改响应行："+updateattention);
        //添加关注
        Attentioninfo attentioninfo = new Attentioninfo();
        attentioninfo.setAttentiontime(new Date());
        attentioninfo.setMyid(myid);
        attentioninfo.setYouid(youid);
        return attentioninfoService.addAttention(attentioninfo);
    }
    /**查询当前作者是否被关注*/
    @RequestMapping("selectbyYM")
    public Object selectbyYM(Integer youid,Integer myid){
        return attentioninfoService.selectbyYM(youid,myid);
    }
    /**取消关注*/
    @RequestMapping("delYM")
    public Object delYM(Integer youid,Integer myid){
        //获取当前作者信息
        Customerinfo findbycid = customerService.findbycid(youid);
        //获取当前作者的关注量
        Integer fence = findbycid.getCustomerfence();
        int count = fence-1;
        //修改当前作者的关注量
        customerService.updateattention(count,youid);
        return attentioninfoService.delYM(youid,myid);
    }
}
