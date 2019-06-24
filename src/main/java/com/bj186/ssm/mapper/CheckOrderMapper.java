package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.CheckOrder;

public interface CheckOrderMapper {
    int deleteByPrimaryKey(String checkOrderId);

    int insert(CheckOrder record);

    int insertSelective(CheckOrder record);

    CheckOrder selectByPrimaryKey(String checkOrderId);

    int updateByPrimaryKeySelective(CheckOrder record);

    int updateByPrimaryKey(CheckOrder record);
}