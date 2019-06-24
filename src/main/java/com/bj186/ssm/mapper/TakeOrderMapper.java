package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.TakeOrder;

public interface TakeOrderMapper {
    int deleteByPrimaryKey(Integer takeoutOrderId);

    int insert(TakeOrder record);

    int insertSelective(TakeOrder record);

    TakeOrder selectByPrimaryKey(Integer takeoutOrderId);

    int updateByPrimaryKeySelective(TakeOrder record);

    int updateByPrimaryKey(TakeOrder record);
}