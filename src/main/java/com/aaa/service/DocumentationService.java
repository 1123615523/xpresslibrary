package com.aaa.service;

import com.aaa.entity.Documentation;
import com.aaa.entity.Resourcesinfo;
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

    /**收藏操作时，对收藏量进行修改*/
    Integer updatefavorites(Integer favorites,Integer did);

    //查询四个类别
    Map<String, Object> findType();

    //测试单个类型返回
    List<Documentation> findTest();

    /**随机查询14条文档信息*/
    List<Documentation> findrand();

    /**修改文档的*/
    Integer editprice(Integer sellingprice,Integer did);

    //查询第一级文档
    PageModel<Documentation> findMoDetails(PageModel pm);

    //查询一级文档下的所有最新资源
    List<Documentation> showNewInfo(Integer did);

    //查询一级分类名称
    Resourcesinfo showTypeInfo(Integer did);

    //模糊搜索
    PageModel<Documentation> mohuQuery(PageModel pm);

    //----------------------后台方法分割线--------------------------

    //用户充值记录
    PageModel<Documentation> houFindDocument(PageModel<Documentation> pm);

}