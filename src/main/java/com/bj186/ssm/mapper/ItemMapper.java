package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}