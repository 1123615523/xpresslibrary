package com.aaa.frontcontroller;/*
 */

import com.aaa.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("Resource")
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @RequestMapping("findResource")
    @ResponseBody
    public Object findResource(){
        return resourceService.findResources();
    }

    @RequestMapping("findResourceById")
    @ResponseBody
    public Object findResourceById(Integer resid){
        return resourceService.findResourceById(resid);
    }

}
