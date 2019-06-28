package com.bj186.ssm.controller;

import com.bj186.ssm.entity.BaseResponse;
import com.bj186.ssm.entity.MyException;
import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
public class OrderController{
    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping(value="/getAllOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getOrders() throws Exception {
        BaseResponse baseResponse = null;
        List<Order> orders = orderService.selectAll();
        if(orders == null) {
           baseResponse = new BaseResponse("200","没找到订单");
           return baseResponse;
        }
        baseResponse = new BaseResponse("200","成功！");
        baseResponse.setData(orders);
        System.out.println(orders.toString());
        return baseResponse;
    }

    @RequestMapping(value="/getOrdersByConditions", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getOrdersByConditions(@RequestBody Map<String,String> map){
        System.out.println("来了");
        BaseResponse baseResponse = null;
        List<Order> orders = orderService.selectAllByConditions(map);
        if(orders == null) {
            baseResponse = new BaseResponse("200","没找到符合条件订单");
            return baseResponse;
        }
        baseResponse = new BaseResponse("200","成功！");
        baseResponse.setData(orders);
        return baseResponse;
    }

    @RequestMapping(value="/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addOrder(@RequestBody Map<String,String> map) throws Exception {
        BaseResponse baseResponse = null;
        Boolean aBoolean = orderService.addOrder(map);
        if(aBoolean){
            baseResponse = new BaseResponse("200","添加成功");
        }else {
            baseResponse = new BaseResponse("-1","添加失败");
        }
        return baseResponse;
    }

    @RequestMapping(value="/updataOrder", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updataOrder(@RequestBody Map<String,String> map) throws Exception {
        BaseResponse baseResponse = null;
        System.out.println(map);
        Boolean aBoolean = orderService.updateOrder(map);
        if(aBoolean){
            baseResponse = new BaseResponse("200","修改成功");
        }else {
            baseResponse = new BaseResponse("-1","修改失败");
        }
        return baseResponse;
    }

}
