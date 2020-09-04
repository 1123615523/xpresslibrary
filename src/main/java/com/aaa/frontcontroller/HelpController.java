package com.aaa.frontcontroller;/*
 */

import com.aaa.entity.Customerinfo;
import com.aaa.entity.Helpinfo;
import com.aaa.service.HelpService;
import com.aaa.service.HelpreplyinfoService;
import com.aaa.utils.PageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Help")
public class HelpController {

    @Resource
    HelpService helpService;

    @Resource
    HelpreplyinfoService helpreplyinfoService;

    @RequestMapping("updHelpInfo")
    @ResponseBody
    public Object updHelpInfo(Integer helpid,Integer replyid,Double money,Integer cusid){;
        return helpreplyinfoService.updHelpInfo(helpid,replyid,money,cusid);
    }

    @RequestMapping("findHelpReplyInfo")
    @ResponseBody
    public Object findHelpReplyInfo(Integer helpid){
        return helpreplyinfoService.findHelpReplyInfo(helpid);
    }

    @RequestMapping("findUserHelp")
    @ResponseBody
    public Object findUserHelp(PageModel<Helpinfo> pm){
        pm = helpService.findUserInfo(pm);
        return pm;
    }

    @RequestMapping("findHelpInfo")
    @ResponseBody
    public Object findHelpInfo(PageModel<Helpinfo> pm){
        pm = helpService.findMenuPath(pm);
        return pm;
    }

    @RequestMapping("delHelpInfo")
    @ResponseBody
    public Object delHelpInfo(Integer id,Integer helpid){
        return helpreplyinfoService.delHelpInfo(id,helpid);
    }

    @RequestMapping("addHelpHuifu")
    @ResponseBody
    public Object addHelpHuifu(String fabuinfo,Integer cusid,Integer helpid,Integer parentid){
        return helpreplyinfoService.addHhelp(fabuinfo, cusid, helpid, parentid);
    }

    @RequestMapping("addHelpReply")
    @ResponseBody
    public Object addHelp(String fabuinfo,Integer cusid,Integer helpid){
        return helpreplyinfoService.addHhelp(fabuinfo,cusid,helpid,0);
    }

    @RequestMapping("findHelp")
    @ResponseBody
    public Object findHelp(Integer helpid,HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        Helpinfo help = helpreplyinfoService.findHelp(helpid);
        List<Map<String, Object>> helpInfo = helpreplyinfoService.findHelpInfo(helpid);
        Customerinfo customer = (Customerinfo) session.getAttribute("cus");
        map.put("help",help);
        map.put("helpInfo",helpInfo);
        map.put("cusid",customer.getCustomerid());
        return map;
    }

    @RequestMapping("addHelp")
    @ResponseBody
    public Object addHelp(@RequestBody Helpinfo helpinfo, HttpSession session) {
        Customerinfo customerinfo = (Customerinfo) session.getAttribute("cus");
        return helpService.addHelp(helpinfo, customerinfo.getCustomerid());
    }



}
