package com.my.scaffold.impl;

import com.my.scaffold.SkuService;
import com.my.scaffold.model.Sku;
import org.springframework.stereotype.Service;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2020/3/4 13:43
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Override
    public Sku getById(String id) {
        Sku  sku = new Sku();
        sku.setId(id);
        sku.setCode("id:"+id);
        sku.setName("name:"+id);
        return sku;
    }
}
