package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer cusid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer cusid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}