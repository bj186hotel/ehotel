package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer empid);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer empid);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}