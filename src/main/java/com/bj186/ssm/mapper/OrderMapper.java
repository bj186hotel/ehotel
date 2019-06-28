package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Map<String,Object> Map);

    int insertSelective(Map<String,String> Map);

    Order selectByPrimaryKey(Integer orderid);

    List<Order> selectAll();

    List<Order> selectAllByCondition(Map<String,String> Map);

    int updateByPrimaryKeySelective(Map<String,String> Map);

    int updateByPrimaryKey(Map<String,String> Map);
}