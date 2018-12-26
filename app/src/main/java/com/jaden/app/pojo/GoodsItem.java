package com.jaden.app.pojo;

import lombok.Data;

@Data
public class GoodsItem {
    private Long id;

    private String title;

    private Double price;

    private String description;

    private Integer sales;

    private String imgUrl;

}