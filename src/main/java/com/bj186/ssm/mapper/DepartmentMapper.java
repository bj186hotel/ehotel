package com.bj186.ssm.mapper;

import com.bj186.ssm.pojo.Department;
import com.bj186.ssm.pojo.Staff;

import java.util.List;

public interface DepartmentMapper {
    /*在用的删除*/
    int deleteByPrimaryKey(Integer depid);

    /*在用的添加*/
    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer depid);

    /*在用的修改*/
    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /*再用的查询*/
    List<Department> selectAll();
}