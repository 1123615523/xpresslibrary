package com.aaa.frontcontroller;

import com.aaa.entity.Documentation;
import com.aaa.entity.Favoritesinfo;
import com.aaa.service.DocumentationService;
import com.aaa.service.FavoritesinfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("favoritesinfo")
public class FavoritesinfoController {

    @Resource
    FavoritesinfoService favoritesinfoService;

    @Resource
    DocumentationService documentationService;
    /**添加收藏*/
    @RequestMapping("addFavorites")
    public Object addFavorites( Integer customerid, Integer documentationid){
        //获取当前文档信息
        Documentation findbydid = documentationService.findbydid(documentationid);
        //获取当前文档的收藏量
        Integer favorites = findbydid.getFavorites();
        int count = favorites+1;
        //修改当前文档的收藏量
        documentationService.updatefavorites(count,documentationid);
        //添加收藏
        Favoritesinfo favoritesinfo = new Favoritesinfo();
        favoritesinfo.setFavoritetime(new Date());
        favoritesinfo.setCustomerid(customerid);
        favoritesinfo.setDocumentationid(documentationid);
        return favoritesinfoService.addFavorites(favoritesinfo);
    }

    /**查询当前文档是否被收藏*/
    @RequestMapping("selectbyCD")
    public Object selectbyCD( Integer customerid, Integer documentationid){
        return favoritesinfoService.selectbyCD(customerid, documentationid);
    }

    /**取消收藏*/
    @RequestMapping("delbyCD")
    public Object delbyCD(Integer customerid, Integer documentationid){
        //获取当前文档信息
        Documentation findbydid = documentationService.findbydid(documentationid);
        //获取当前文档的收藏量
        Integer favorites = findbydid.getFavorites();
        int count = favorites-1;
        //修改当前文档的收藏量
        documentationService.updatefavorites(count,documentationid);
        return favoritesinfoService.delbyCD(customerid,documentationid);
    }

    /**w我的收藏*/
    @RequestMapping("MyFavorites")
    public Object MyFavorites(Integer customerid){
        return favoritesinfoService.MyFavorites(customerid);
    }
}
