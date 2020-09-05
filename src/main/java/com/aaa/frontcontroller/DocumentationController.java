package com.aaa.frontcontroller;

import com.aaa.entity.Customerinfo;
import com.aaa.entity.Documentation;
import com.aaa.service.DocumentationService;
import com.aaa.utils.PageModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("documentation")
public class DocumentationController {

    @Resource
    DocumentationService documentationService;

    @RequestMapping("findNewDocument")
    public Object findNewDocument(Integer did){
        return documentationService.findNewDocument(did);
    }

    @RequestMapping("findDocumentByResorce")
    public Object findDocumentByResorce(PageModel<Documentation> pm){
        pm = documentationService.findDocumentByResorce(pm);
        return pm;
    }


    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpSession session, String title, String essentialcode, Integer detaisid, String introduction, Integer previewpage, Integer allowdownload, Integer original, Integer sellingprice) throws IOException {
        return documentationService.upload(file,session,title,essentialcode,detaisid,introduction,previewpage,allowdownload,original,sellingprice);
    }

    /**文件下载*/
    @RequestMapping("download")
    public String download(Integer did, HttpServletResponse response,HttpSession session){
        System.out.println(did);
        Customerinfo cus = (Customerinfo) session.getAttribute("cus");
        String customerid = cus.getCustomerpic();
        System.out.println(customerid);
        return "1";
    }

    /**今日特别推荐查询方法*/
    @RequestMapping("documentationespecially")
    public Object documentationespecially(){
        return documentationService.documentationespecially();
    }

    @RequestMapping("documentationlatest")
    public Object documentationlatest(){
        return documentationService.documentationlatest();
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

    /**根据ppt格式进行查询随机14条数据*/
    @RequestMapping("documentationppt")
    public Object documentationppt(){
        return documentationService.documentationppt();
    }

    /**根据用户个人上传的文档数量查询牛人榜*/
    @RequestMapping("findbull")
    public Object findbull(){
        return documentationService.findbull();
    }

    /**根据文档id获取文档的详细信息*/
    @RequestMapping("findbydid")
    public Object findbydid(Integer did){
        return documentationService.findbydid(did);
    }
}
