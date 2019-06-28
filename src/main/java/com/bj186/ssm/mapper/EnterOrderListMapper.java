package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.EnterOrderList;

import java.util.List;
import java.util.Map;

public interface EnterOrderListMapper {
    int deleteByPrimaryKey(Integer enterListId);

    int insert(EnterOrderList record);

    int insertSelective(List<Map<String,String>> list);

    EnterOrderList selectByPrimaryKey(Integer enterListId);

    int updateByPrimaryKeySelective(EnterOrderList record);

    int updateByPrimaryKey(EnterOrderList record);
}