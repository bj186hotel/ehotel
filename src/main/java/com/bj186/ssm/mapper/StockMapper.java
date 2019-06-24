package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Stock;

public interface StockMapper {
    int deleteByPrimaryKey(String stockId);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(String stockId);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}