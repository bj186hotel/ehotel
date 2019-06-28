package com.bj186.ssm.service;

import com.bj186.ssm.entity.MyException;
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
     * @param map
     * @return
     */
    Boolean addOrder(Map<String,String> map) throws Exception;

    /**
     * 修改订单
     * @param map
     * @return
     */
    Boolean updateOrder(Map<String,String> map);

    /**
     * 查看所有订单
     * @return
     */
    List<Order> selectAll() throws Exception;

    /**
     * 根据订单条件查询（用户名、房间号、状态、下单时间）
     * @param map
     * @return
     */
    List<Order> selectAllByConditions(Map<String,String> map);
}
