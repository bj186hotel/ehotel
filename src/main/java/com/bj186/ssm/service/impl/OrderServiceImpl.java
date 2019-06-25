package com.bj186.ssm.service.impl;

import com.bj186.ssm.mapper.OrderMapper;
import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 郑金城
 * @title: OrderServiceImpl
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/2414:38
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Boolean addOrder(Order order) {
        int i = orderMapper.insertSelective(order);
        if (i > 0)
            return true;
        return false;
    }

    @Override
    public Boolean updateOrder(Order order) {
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i > 0)
            return true;
        return false;
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> selectAllByConditions(Map<String, Object> map) {
        return orderMapper.selectAllByCondition(map);
    }

}
