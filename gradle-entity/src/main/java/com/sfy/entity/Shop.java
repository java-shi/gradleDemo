package com.sfy.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 商品信息
 * @Author: Sfy
 * @Date: 2020/7/7 0007
 */
@Data
public class Shop {
    /**
     * 商品标识
     */
    private Integer shopId;
    /**
     * 商品名称
     */
    private String shopName;
    /**
     * 商品图片
     */
    private String picUrl;
    /**
     * 日期
     */
    private Timestamp shopTime;
    /**
     * 商品类型
     */
    private ShopType shopType;

    /**
     * 是否有效 1：是 2：否
     */
    private Integer entityId;
}
