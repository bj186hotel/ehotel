package com.bj186.ssm.controller;

import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 郑金城
 * @title: OrderController
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/259:13
 */
@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping(value="/getAllOrder", method = RequestMethod.POST)
    @ResponseBody
    public List<Order> getAllOrder(){
        return orderService.selectAll();
    }
}
