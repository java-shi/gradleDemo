package com.sfy.entity;

import lombok.Data;

/**
 * 类型信息
 * @Author: Sfy
 * @Date: 2020/7/7 0007
 */
@Data
public class ShopType {
    /**
     * 商品类型唯一标识
     */
    private Integer typeId;

    /**
     * 商品类型名称
     */
    private String typeName;
}
