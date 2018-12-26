package com.jaden.app.mapper;

import com.jaden.app.models.GoodsItemModel;
import com.jaden.app.pojo.GoodsItem;

import java.util.List;

public interface GoodsItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsItem record);

    int insertSelective(GoodsItem record);

    GoodsItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsItem record);

    int updateByPrimaryKey(GoodsItem record);

    List<GoodsItemModel> listGoods();
}