package com.sfy.controller;

import com.sfy.entity.Result;
import com.sfy.entity.Shop;
import com.sfy.entity.ShopType;
import com.sfy.service.ShopService;
import com.sfy.utils.DxlFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Sfy
 * @Date: 2020/7/3 0003
 */
@Slf4j
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(method = RequestMethod.GET,path = "/getShopList")
    public List<Shop> getShopList(){
        return shopService.getShopList();
    }

    @RequestMapping(method = RequestMethod.GET,path = "/getTypeList")
    public List<ShopType> getTypeList(){
        return shopService.getTypeList();
    }

    @RequestMapping(method = RequestMethod.POST,path = "/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 文件上传后的路径
        String filePath = "E://work/frontPage/demo0703/static/image/"+ fileName;
        log.info(filePath);
        File dest = new File(filePath );
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return fileName;
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/deleteImage/{fileName}")
    public String deleteImage(@PathVariable("fileName") String fileName){
        // 文件上传后的路径
        String filePath = "E://work/frontPage/demo0703/static/image/"+ fileName;
        File file = new File(filePath);
        if(!file.exists()){
            return "无此文件";
        }
        boolean delete = file.delete();
        log.info("删除已经上传成功的图片结果："+delete+"");
        return "删除成功";
    }

    /**
     * 添加商品
     * @param shop
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,path = "/addShop")
    public Result addShop(@RequestBody Shop shop){
        log.info(shop.toString());
        Result result = shopService.addShop(shop);
        return result;
    }

    /**
     * 修改商品
     * @param shop
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,path = "/updateShop")
    public Result updateShop(@RequestBody Shop shop){
        log.info(shop.toString());
        Result result = shopService.updateShop(shop);
        return result;
    }


    /**
     * 删除单个商品
     * @param shopId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE,path = "/deleteShopById/{shopId}")
    public Result deleteShopById(@PathVariable("shopId") String shopId){
        Result result = shopService.deleteShopById(shopId);
        return result;
    }

    /**
     * 下载图片
     * @param request
     * @param response
     * @param fileName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,path = "/downImage/{fileName}")
    public void downImage(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName") String fileName){
        String filePath = "E://work/frontPage/demo0703/static/image/"+ fileName;
        DxlFileUtil.downloadFile(request,response,filePath,"1123123.jpg");
    }

    /**
     * 查询单个商品
     * @param shopId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,path = "/selectShopById/{shopId}")
    public Result selectShopById(@PathVariable("shopId") String shopId){
        return shopService.selectShopById(shopId);
    }
}
