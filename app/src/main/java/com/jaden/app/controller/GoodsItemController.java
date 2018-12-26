package com.jaden.app.controller;

import com.jaden.app.models.GoodsItemModel;
import com.jaden.app.service.GoodsItemService;
import com.jaden.common.exception.BizException;
import com.jaden.common.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tangjiejin on 2018/12/26
 */
@RestController
public class GoodsItemController extends BaseController {

    @Autowired
    GoodsItemService goodsItemService;


    /**
     * 创建商品
     *
     * @param itemModel
     * @return
     * @throws BizException
     */
    @PostMapping("/goods/createItem")
    public ResultData createItem(GoodsItemModel itemModel) throws BizException {
        validatePropertes(itemModel);
        GoodsItemModel goodsItemModel = goodsItemService.createItem(itemModel);
        return ResultData.retSuccess(goodsItemModel);
    }

    /**
     * 商品列表查询
     *
     * @return
     * @throws BizException
     */
    @GetMapping("/goods/listGoods")
    public ResultData listGoods() {
        List<GoodsItemModel> goodsItemModels = goodsItemService.listGoods();
        return ResultData.retSuccess(goodsItemModels);
    }

}
