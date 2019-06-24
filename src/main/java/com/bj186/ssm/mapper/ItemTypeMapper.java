package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.ItemType;

public interface ItemTypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(ItemType record);

    int insertSelective(ItemType record);

    ItemType selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(ItemType record);

    int updateByPrimaryKey(ItemType record);
}