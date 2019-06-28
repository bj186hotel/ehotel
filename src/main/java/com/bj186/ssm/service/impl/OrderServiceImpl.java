package com.bj186.ssm.service.impl;

import com.bj186.ssm.entity.MyException;
import com.bj186.ssm.mapper.MemberMapper;
import com.bj186.ssm.mapper.OrderMapper;
import com.bj186.ssm.mapper.RoomMapper;
import com.bj186.ssm.pojo.Member;
import com.bj186.ssm.pojo.Order;
import com.bj186.ssm.pojo.Room;
import com.bj186.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Boolean addOrder(Map<String, String> map) throws Exception {
        Integer roomId = Integer.parseInt(map.get("roomId"));
        String menNum = map.get("menNum");
        Member member = memberMapper.selectByMenNum(menNum);
        if (member == null) {
            throw new MyException("-1","用户账号错误");
        }
        map.put("memId",member.getMemid().toString());
        Room room = roomMapper.selectByPrimaryKey(roomId);
        Date inTime = Date.valueOf(map.get("intime"));
        Date outTime = Date.valueOf(map.get("outtime"));
        Boolean canRoom = isCanRoom(room, inTime, outTime);
        if (!canRoom)
            return false;
        int i = orderMapper.insertSelective(map);
        if (i > 0)
            return true;
        return false;
    }

    /**
     * 判断房间在指定时间范围内是否可预订
     *
     * @param room    指定房间，该房间包含它的订单（正在入住、和预订了的）
     * @param inTime  本次入住时间
     * @param outTime 本次离店时间
     * @return
     */
    public Boolean isCanRoom(Room room, Date inTime, Date outTime) {
        List<Order> orders = room.getOrders();
        if (orders == null)
            return true;
        for (int i = 0; i < orders.size(); i++) {
            //判断本次入住时间要么大于订单的离店时间，或本次离店时间小于订单入住时间
            if (!(outTime.getTime() <= orders.get(i).getIntime().getTime() || inTime.getTime() >= orders.get(i).getOuttime().getTime())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean updateOrder(Map<String,String> map) {
        int i = orderMapper.updateByPrimaryKeySelective(map);
        if (i > 0)
            return true;
        return false;
    }

    @Override
    public List<Order> selectAll() throws Exception {
        try {
            return orderMapper.selectAll();
        } catch (Exception e) {
            throw new MyException("-1", "服务器异常");
        }
    }

    @Override
    public List<Order> selectAllByConditions(Map<String, String> map) {
        return orderMapper.selectAllByCondition(map);
    }

}
