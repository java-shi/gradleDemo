package com.sfy.service.impl;

import com.sfy.entity.Result;
import com.sfy.entity.Shop;
import com.sfy.entity.ShopType;
import com.sfy.mapper.ShopMapper;
import com.sfy.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @Author: Sfy
 * @Date: 2020/7/3 0003
 */
@Slf4j
@Service
public class ShopServiceImpl implements ShopService {


    @Autowired(required = false)
    private ShopMapper shopMapper;


    @Override
    public List<Shop> getShopList() {
        return shopMapper.getShopList();
    }

    @Override
    public List<ShopType> getTypeList() {
        return shopMapper.getTypeList();
    }

    @Override
    public Result addShop(Shop shop) {
        Result result = new Result();
        int id = shopMapper.addShop(shop);
        if(id == 0 || id < 0) {
            return result;
        }
        result.setCode(200);
        result.setMessage("添加商品成功");
        return result;
    }

    @Override
    public Result deleteShopById(String shopId) {
        Result result = new Result();
        if(StringUtils.isEmpty(shopId)){
            return result;
        }
        Shop shop = shopMapper.selectShopById(shopId);
        if(shop == null){
            result.setMessage("无此商品");
            return result;
        }
        int i = shopMapper.deleteShopById(shopId);
        if(i <= 0){
            result.setMessage("删除失败");
            return result;
        }
        result.setMessage("删除成功");
        result.setCode(200);
        return result;
    }

    @Override
    public Result selectShopById(String shopId) {
        Shop shop = shopMapper.selectShopById(shopId);
        Result result = new Result();
        if(shop == null){
            result.setMessage("无此商品");
            return result;
        }
        result.setCode(200);
        result.setMessage("有此商品");
        return result;
    }

    @Override
    public Result updateShop(Shop shop) {
        Result result = new Result();
        Shop shop1 = shopMapper.selectShopById(shop.getShopId() + "");
        if(shop1 == null){
            result.setMessage("无此商品");
            return result;
        }else{
            shopMapper.updateShop(shop);
            result.setCode(200);
            result.setMessage("修改成功");
        }
        return result;
    }


}
