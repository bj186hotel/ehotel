package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.TakeOrder;

public interface TakeOrderMapper {
    int deleteByPrimaryKey(String takeoutOrderId);

    int insert(TakeOrder record);

    int insertSelective(TakeOrder record);

    TakeOrder selectByPrimaryKey(String takeoutOrderId);

    int updateByPrimaryKeySelective(TakeOrder record);

    int updateByPrimaryKey(TakeOrder record);
}