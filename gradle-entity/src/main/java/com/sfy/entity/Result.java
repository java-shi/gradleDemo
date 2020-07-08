package com.sfy.entity;


import lombok.Data;

/**
 * 响应结果
 * @Author: Sfy
 * @Date: 2020/7/3 0003
 */
@Data
public class Result {
    /**
     * 响应编码
     */
    private Integer code = 999999;
    /**
     * 响应信息
     */
    private String message = "错误了";


}
