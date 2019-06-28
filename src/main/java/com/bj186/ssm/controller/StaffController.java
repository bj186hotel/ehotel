package com.bj186.ssm.controller;


import com.bj186.ssm.entity.BaseResponse;
import com.bj186.ssm.mapper.StaffMapper;
import com.bj186.ssm.mapper.UserMapper;
import com.bj186.ssm.pojo.Department;
import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.pojo.Staff;
import com.bj186.ssm.service.OrderService;
import com.bj186.ssm.service.StaffService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping(value = "staff")
public class StaffController {

    @Resource(name = "staffService")
    private StaffService staffService;

    @RequestMapping(value="/addStaff", method = RequestMethod.POST)
    @ResponseBody
    public int addStaff() {

        Department department = new Department();
        department.setDepid(1002);
        Staff staff = new Staff();
        staff.setDepartment(department);
        staff.setEmpname("李收拾2");
        staff.setEmpsex("男");
        staff.setEmpage(17);
        staff.setEmpphone("1844562159");
        staff.setEmpemail("1154778421@qq.com");
        staff.setEmppay("2000");
        staff.setRemark("特长是没有特长");
        staffService.addStaff(staff);

        return 1;
    }


}
