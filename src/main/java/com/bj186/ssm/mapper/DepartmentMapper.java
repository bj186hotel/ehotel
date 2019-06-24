package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer depid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer depid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}