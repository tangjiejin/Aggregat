package com.jaden.app.models;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by tangjiejin on 2018/12/26
 */
@Data
public class GoodsItemModel {

    Long id;

    @NotBlank(message = "标题不能为空")
    String title;

    @NotNull(message = "价格不为空")
    @Min(value = 0,message = "价格不合法")
    BigDecimal price;

    @NotNull(message = "库存不为空")
    @Min(value = 0,message = "库存不合法")
    Integer stock;

    @NotBlank(message = "描述不能为空")
    String description;

    Integer sales;

    @NotBlank(message = "图片不能为空")
    String imgUrl;

}
