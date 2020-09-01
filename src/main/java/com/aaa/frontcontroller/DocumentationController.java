package com.aaa.frontcontroller;

import com.aaa.entity.Documentation;
import com.aaa.service.DocumentationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("documentation")
public class DocumentationController {

    @Resource
    DocumentationService documentationService;

    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpSession session, String title, String essentialcode, Integer detaisid, String introduction, Integer previewpage, Integer allowdownload, Integer original, Integer sellingprice) throws IOException {
        return documentationService.upload(file,session,title,essentialcode,detaisid,introduction,previewpage,allowdownload,original,sellingprice);
    }

    /**今日特别推荐查询方法*/
    @RequestMapping("documentationespecially")
    public Object documentationespecially(){
        return documentationService.documentationespecially();
    }

    @RequestMapping("bydid")
    public Object bydid(Integer did){
        return documentationService.bydid(did);
    }

    /**根据用户id获取用户的所有文档信息*/
    @RequestMapping("findbyid")
    public Object findbyid(Integer authored){
        List<Documentation> findbyid = documentationService.findbyid(authored);
        return findbyid;
    }


}
