package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.TakeOut;

public interface TakeOutMapper {
    int deleteByPrimaryKey(String takeoutId);

    int insert(TakeOut record);

    int insertSelective(TakeOut record);

    TakeOut selectByPrimaryKey(String takeoutId);

    int updateByPrimaryKeySelective(TakeOut record);

    int updateByPrimaryKey(TakeOut record);
}