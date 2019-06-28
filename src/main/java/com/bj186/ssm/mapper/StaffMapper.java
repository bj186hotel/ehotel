package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Staff;
import com.bj186.ssm.pojo.User;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer empid);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer empid);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> selectAll();
}