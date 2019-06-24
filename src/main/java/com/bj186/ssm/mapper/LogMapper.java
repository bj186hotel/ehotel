package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Log;

public interface LogMapper {
    int deleteByPrimaryKey(Integer logsid);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Integer logsid);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}