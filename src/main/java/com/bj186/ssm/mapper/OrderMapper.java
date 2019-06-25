package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderid);

    List<Order> selectAll();

    List<Order> selectAllByCondition(Map<String,Object> Map);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}