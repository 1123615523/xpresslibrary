package com.aaa.service;

import com.aaa.entity.Documentation;
import com.aaa.utils.PageModel;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface DocumentationService {

    /**上传文件添加方法*/
    Integer add(Documentation documentation);
    /**上传转换方法*/
    String upload(@RequestParam("file") MultipartFile file, HttpSession session, String title, String essentialcode, Integer detaisid, String introduction, Integer previewpage, Integer allowdownload, Integer original, Integer sellingprice);
    /**今日特别推荐查询方法*/
    List<Documentation> documentationespecially();

    /**根据文档id值进行查询文档详细信息*/
    Map<String,Object> bydid(Integer did);

    /**根据用户自己的id获取自己的所有文档信息*/
    List<Documentation> findbyid(Integer authored);

    /**根据文档id获取文档信息*/
    Documentation findbydid(Integer did);

    /**最近上传查询方法*/
    List<Documentation> documentationlatest();

    /**根据ppt格式进行查询随机14条数据*/
    List<Documentation> documentationppt();

    /**根据用户个人上传的文档数量查询牛人榜*/
    List<Map<String,Object>> findbull();

    //分页查询资源下的详细信息
    PageModel<Documentation> findDocumentByResorce(PageModel pm);

    //查询最新更新的资源
    List<Documentation> findNewDocument(Integer did);
}
