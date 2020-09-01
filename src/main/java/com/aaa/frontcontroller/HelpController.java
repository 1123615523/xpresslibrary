package com.aaa.frontcontroller;/*
 */

import com.aaa.entity.Customerinfo;
import com.aaa.entity.Helpinfo;
import com.aaa.service.HelpService;
import com.aaa.utils.PageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("Help")
public class HelpController {

    @Resource
    HelpService helpService;

    @RequestMapping("addHelp")
    @ResponseBody
    public Object addHelp(@RequestBody Helpinfo helpinfo, HttpSession session) {
        Customerinfo customerinfo = (Customerinfo) session.getAttribute("cus");
        return helpService.addHelp(helpinfo, customerinfo.getCustomerid());
    }

    @RequestMapping("findHelpInfo")
    @ResponseBody
    public Object findHelpInfo(PageModel<Helpinfo> pm){
        pm = helpService.findMenuPath(pm);
        return pm;
    }

}
