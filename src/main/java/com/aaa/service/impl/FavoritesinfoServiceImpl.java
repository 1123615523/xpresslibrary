package com.aaa.service.impl;

import com.aaa.dao.FavoritesinfoDao;
import com.aaa.entity.Favoritesinfo;
import com.aaa.service.FavoritesinfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class FavoritesinfoServiceImpl implements FavoritesinfoService {

    @Resource
    FavoritesinfoDao favoritesinfoDao;

    /**添加收藏*/
    @Override
    public Integer addFavorites(Favoritesinfo favoritesinfo) {
        return favoritesinfoDao.addFavorites(favoritesinfo);
    }


    /**查询当前文档是否被收藏*/
    @Override
    public Integer selectbyCD(Integer customerid, Integer documentationid) {
        return favoritesinfoDao.selectbyCD(customerid,documentationid);
    }

    /**取消收藏*/
    @Override
    public Integer delbyCD(Integer customerid, Integer documentationid) {
        return favoritesinfoDao.delbyCD(customerid,documentationid);
    }


}
