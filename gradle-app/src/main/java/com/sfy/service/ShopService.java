package com.sfy.service;


import com.sfy.entity.Result;
import com.sfy.entity.Shop;
import com.sfy.entity.ShopType;

import java.util.List;

/**
 * @Author: Sfy
 * @Date: 2020/7/3 0003
 */
public interface ShopService {
    /**
     * 获取商品列表
     * @return
     */
    List<Shop> getShopList();

    /**
     * 获取类型列表
     * @return
     */
    List<ShopType> getTypeList();

    /**
     * 添加商品
     * @param shop
     * @return
     */
    Result addShop(Shop shop);

    /**
     * 删除商品
     * @param shopId
     * @return
     */
    Result deleteShopById(String shopId);

    /**
     * 查询单个商品
     * @param shopId   商品唯一标识
     * @return
     */
    Result selectShopById(String shopId);

    /**
     * 修改商品
     * @param shop
     * @return
     */
    Result updateShop(Shop shop);
}
