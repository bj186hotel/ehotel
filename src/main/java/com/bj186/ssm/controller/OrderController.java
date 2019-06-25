package com.bj186.ssm.controller;

import com.bj186.ssm.entity.BaseResponse;
import com.bj186.ssm.entity.MyException;
import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郑金城
 * @title: OrderController
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/259:13
 */
@Controller
@RequestMapping(value = "order")
public class OrderController extends BaseController{
    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping(value="/getAllOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getAllOrder() throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        List<Order> orders = orderService.selectAll();
        if(orders.size() > 0) {
            baseResponse.victory(orders);
        }else {
            baseResponse.defeated();
        }
        return baseResponse;
    }

    public BaseResponse getAllOrderByConditions(){
        BaseResponse baseResponse = new BaseResponse();
        return baseResponse;
    }
}
