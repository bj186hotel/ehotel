package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.EnterOrderList;

public interface EnterOrderListMapper {
    int deleteByPrimaryKey(Integer enterListId);

    int insert(EnterOrderList record);

    int insertSelective(EnterOrderList record);

    EnterOrderList selectByPrimaryKey(Integer enterListId);

    int updateByPrimaryKeySelective(EnterOrderList record);

    int updateByPrimaryKey(EnterOrderList record);
}