package com.my.scaffold.dal.mapper;

import com.my.scaffold.dal.entity.PurStockoutOrderTrade;

public interface PurStockoutOrderTradeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录
     */
    int insert(PurStockoutOrderTrade record);

    /**
     * 插入记录，只插入不为空的属性
     */
    int insertSelective(PurStockoutOrderTrade record);

    /**
     * 根据主键id查询指定记录
     */
    PurStockoutOrderTrade selectByPrimaryKey(Long id);

    /**
     * 根据主键修改记录，只修改参数对象中属性不为空的
     */
    int updateByPrimaryKeySelective(PurStockoutOrderTrade record);

    /**
     * 根据主键修改指定记录
     */
    int updateByPrimaryKey(PurStockoutOrderTrade record);
}