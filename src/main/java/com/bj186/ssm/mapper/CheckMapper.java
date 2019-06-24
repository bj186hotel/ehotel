package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Check;

public interface CheckMapper {
    int deleteByPrimaryKey(String checkId);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(String checkId);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
}