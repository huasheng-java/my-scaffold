package com.my.scaffold.dal.mapper;

import com.my.scaffold.dal.entity.PurProducerGoodsInfo;

public interface PurProducerGoodsInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PurProducerGoodsInfo record);

    int insertSelective(PurProducerGoodsInfo record);

    PurProducerGoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PurProducerGoodsInfo record);

    int updateByPrimaryKey(PurProducerGoodsInfo record);
}