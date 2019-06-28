package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.CusOrder;
import com.bj186.ssm.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CusOrderMapper {
    int deleteByPrimaryKey(Integer cusorderid);

    int insert(CusOrder record);

    List<Customer> selectCusByOrderId(Map<String,String> map);

    int insertSelective(CusOrder record);
}