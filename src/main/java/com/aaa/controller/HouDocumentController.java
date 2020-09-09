package com.aaa.controller;/*
 */

import com.aaa.entity.Documentation;
import com.aaa.service.DocumentationService;
import com.aaa.utils.PageModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("houDocument")
public class HouDocumentController {


    @Resource
    DocumentationService documentationService;


    @RequestMapping("houFindDocument")
    public Object houFindDocument(PageModel<Documentation> pm){
        pm = documentationService.houFindDocument(pm);
        return pm;
    }

}
