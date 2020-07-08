package com.sfy.mapper;

import com.sfy.entity.Shop;
import com.sfy.entity.ShopType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Sfy
 * @Date: 2020/7/3 0003
 */
public interface ShopMapper {
    List<Shop> getShopList();

    List<ShopType> getTypeList();

    int addShop(@Param("shop") Shop shop);

    Shop selectShopById(@Param("shopId") String shopId);

    int deleteShopById(@Param("shopId") String shopId);

    void updateShop(@Param("shop") Shop shop);
}
