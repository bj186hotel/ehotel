package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.EnterOrderList;

public interface EnterOrderListMapper {
    int deleteByPrimaryKey(String enterListId);

    int insert(EnterOrderList record);

    int insertSelective(EnterOrderList record);

    EnterOrderList selectByPrimaryKey(String enterListId);

    int updateByPrimaryKeySelective(EnterOrderList record);

    int updateByPrimaryKey(EnterOrderList record);
}