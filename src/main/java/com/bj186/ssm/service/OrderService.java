package com.bj186.ssm.service;

import com.bj186.ssm.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author 郑金城
 * @title: OrderService
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/2414:08
 */
public interface OrderService {
    /**
     * 添加订单
     * @param order
     * @return
     */
    Boolean addOrder(Order order);

    /**
     * 修改订单
     * @param order
     * @return
     */
    Boolean updateOrder(Order order);

    /**
     * 查看所有订单
     * @return
     */
    List<Order> selectAll();

    /**
     * 根据订单条件查询
     * @param map
     * @return
     */
    List<Order> selectAllByConditions(Map<String,Object> map);
}
