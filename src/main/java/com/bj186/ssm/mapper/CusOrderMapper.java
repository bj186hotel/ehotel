package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.CusOrder;

public interface CusOrderMapper {
    int deleteByPrimaryKey(Integer cusorderid);

    int insert(CusOrder record);

    int insertSelective(CusOrder record);
}