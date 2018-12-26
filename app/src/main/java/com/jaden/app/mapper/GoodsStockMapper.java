package com.jaden.app.mapper;

import com.jaden.app.pojo.GoodsStock;

public interface GoodsStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsStock record);

    int insertSelective(GoodsStock record);

    GoodsStock selectByPrimaryKey(Long id);

    GoodsStock selectByGoodsItemId(Long itemId);

    int updateByPrimaryKeySelective(GoodsStock record);

    int updateByPrimaryKey(GoodsStock record);
}