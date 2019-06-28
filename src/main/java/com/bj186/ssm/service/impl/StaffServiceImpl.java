package com.bj186.ssm.service.impl;

import com.bj186.ssm.mapper.StaffMapper;
import com.bj186.ssm.pojo.Department;
import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.pojo.Staff;
import com.bj186.ssm.service.StaffService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    private ApplicationContext context = null;
    @Before
    public void  init(){
        context = new ClassPathXmlApplicationContext("config/spring.xml");
    }


    @Override
    public void addStaff(Staff staff) {
        SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);

        staffMapper.insert(staff);

        sqlSession.commit();

    }

    @Override
    public Boolean updateStaff(Staff staff) {
        return null;
    }

    @Override
    public List<Order> selectAll() {
        return null;
    }

    @Override
    public List<Order> selectAllByConditions(Map<String, Object> map) {
        return null;
    }
}
