package com.my.sacffold.controller;

import com.my.scaffold.SkuService;
import com.my.scaffold.model.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2020/3/4 15:51
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Controller
@RequestMapping("/test")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @GetMapping(value = "query")
    @ResponseBody
    public String query(){
        Sku sku = skuService.getById("i");
       String result = sku.getId()+" "+sku.getCode()+" "+sku.getName();
       return result;
    }
}
