package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.EnterOrder;

public interface EnterOrderMapper {
    int deleteByPrimaryKey(Integer enterOrderId);

    int insert(EnterOrder record);

    int insertSelective(EnterOrder record);

    EnterOrder selectByPrimaryKey(Integer enterOrderId);

    int updateByPrimaryKeySelective(EnterOrder record);

    int updateByPrimaryKey(EnterOrder record);
}