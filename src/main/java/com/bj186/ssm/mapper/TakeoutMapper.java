package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Takeout;

public interface TakeoutMapper {
    int deleteByPrimaryKey(String takeoutId);

    int insert(Takeout record);

    int insertSelective(Takeout record);

    Takeout selectByPrimaryKey(String takeoutId);

    int updateByPrimaryKeySelective(Takeout record);

    int updateByPrimaryKeyWithBLOBs(Takeout record);

    int updateByPrimaryKey(Takeout record);
}