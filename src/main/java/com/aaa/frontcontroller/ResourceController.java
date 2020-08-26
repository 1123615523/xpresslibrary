package com.aaa.frontcontroller;/*
 */

import com.aaa.entity.Resourcesinfo;
import com.aaa.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("Resource")
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @RequestMapping("findResource")
    @ResponseBody
    public Object findResource(){
        List<Resourcesinfo> resources = resourceService.findResources();
        return resources;
    }

}
