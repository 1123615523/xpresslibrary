package com.aaa.dao;

import com.aaa.entity.Favoritesinfo;

import java.util.List;
import java.util.Map;

public interface FavoritesinfoDao {

    /**添加收藏*/
    Integer addFavorites(Favoritesinfo favoritesinfo);

    /**查询当前文档是否被收藏*/
     Integer selectbyCD(Integer customerid, Integer documentationid);

     /**取消收藏*/
     Integer delbyCD(Integer customerid,Integer documentationid);

     /**我的收藏*/
    List<Map<String,Object>> MyFavorites(Integer customerid);

}
