package com.my.scaffold.dal.mapper;

import com.my.scaffold.dal.entity.ZcySkuCreateRecord;

public interface ZcySkuCreateRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录
     */
    int insert(ZcySkuCreateRecord record);

    /**
     * 插入记录，只插入不为空的属性
     */
    int insertSelective(ZcySkuCreateRecord record);

    /**
     * 根据主键id查询指定记录
     */
    ZcySkuCreateRecord selectByPrimaryKey(Long id);

    /**
     * 根据主键修改记录，只修改参数对象中属性不为空的
     */
    int updateByPrimaryKeySelective(ZcySkuCreateRecord record);

    /**
     * 根据主键修改指定记录
     */
    int updateByPrimaryKey(ZcySkuCreateRecord record);
}