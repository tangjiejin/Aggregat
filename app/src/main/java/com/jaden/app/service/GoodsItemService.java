package com.jaden.app.service;

import com.jaden.app.mapper.GoodsItemMapper;
import com.jaden.app.mapper.GoodsStockMapper;
import com.jaden.app.models.GoodsItemModel;
import com.jaden.app.pojo.GoodsItem;
import com.jaden.app.pojo.GoodsStock;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tangjiejin on 2018/12/26
 */
@Service
public class GoodsItemService {

    @Resource
    GoodsItemMapper goodsItemMapper;

    @Resource
    GoodsStockMapper goodsStockMapper;

    private GoodsItem convertToGoodsItem(GoodsItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        GoodsItem goodsItem = new GoodsItem();
        BeanUtils.copyProperties(itemModel, goodsItem);
        goodsItem.setPrice(itemModel.getPrice().doubleValue());
        return goodsItem;
    }

    @Transactional
    public GoodsItemModel createItem(GoodsItemModel itemModel) {
        GoodsItem goodsItem = convertToGoodsItem(itemModel);
        // 插入商品
        goodsItemMapper.insertSelective(goodsItem);
        GoodsStock goodsStock = new GoodsStock();
        goodsStock.setItemId(goodsItem.getId());
        goodsStock.setStock(itemModel.getStock());
        // 插入库存
        goodsStockMapper.insertSelective(goodsStock);
        // 返回插入的数据
        return getGoodsItemModelById(goodsItem.getId());
    }

    public GoodsItemModel getGoodsItemModelById(Long itemId) {
        GoodsItem goodsItem = goodsItemMapper.selectByPrimaryKey(itemId);
        GoodsStock goodsStock = goodsStockMapper.selectByGoodsItemId(itemId);
        if (goodsItem == null) {
            return null;
        }
        GoodsItemModel goodsItemModel = new GoodsItemModel();
        BeanUtils.copyProperties(goodsItem, goodsItemModel);
        goodsItemModel.setPrice(new BigDecimal(goodsItem.getPrice()));
        goodsItemModel.setStock(goodsStock == null ? 0 : goodsStock.getStock());
        return goodsItemModel;
    }

    public List<GoodsItemModel> listGoods() {
        return goodsItemMapper.listGoods();
    }
}
