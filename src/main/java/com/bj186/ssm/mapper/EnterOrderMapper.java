package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.EnterOrder;

import java.util.List;
import java.util.Map;

public interface EnterOrderMapper {
    int deleteByPrimaryKey(Integer enterOrderId);

    int insert(Map<String,String> Map);

    int insertSelective(Map<String,String> Map);

    EnterOrder selectByPrimaryKey(Integer enterOrderId);

    List<EnterOrder> selectAll();

    List<EnterOrder> selectAllByCondition(Map<String,String> Map);

    int updateByPrimaryKeySelective(Map<String,String> Map);

    int updateByPrimaryKey(Map<String,String> Map);
}