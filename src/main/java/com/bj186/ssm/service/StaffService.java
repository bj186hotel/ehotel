package com.bj186.ssm.service;

import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.pojo.Staff;

import java.util.List;
import java.util.Map;

public interface StaffService {
    /**
     * 添加员工
     * @param staff
     * @return
     */
    void addStaff(Staff staff);

    /**
     * 修改员工信息
     * @param staff
     * @return
     */
    Boolean updateStaff(Staff staff);

    /**
     * 查看所有员工列表
     * @return
     */
    List<Order> selectAll();

    /**
     * 根据员工条件查询（部门,员工id）
     * @param map
     * @return
     */
    List<Order> selectAllByConditions(Map<String,Object> map);

}
