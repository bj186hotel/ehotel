package com.bj186.ssm.service;

import com.bj186.ssm.pojo.EnterOrder;
import com.bj186.ssm.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author 郑金城
 * @title: EnterOrderService
 * @projectName ssm
 * @description: TODO
 * @date 2019/6/279:21
 */
public interface EnterOrderService {
    /**
     * 生成进货单
     * @param map
     * @return
     */
    Boolean addEnterOrder(Map<String,String> map);

    /**
     * 修改进货单
     * @param map
     * @return
     */
    Boolean updateEnterOrder(Map<String,String> map);

    /**
     * 查询进货单
     * @return
     */
    List<EnterOrder> selectAll();

    /**
     * 条件查询
     * @param map
     * @return
     */
    List<EnterOrder> selectAllByConditions(Map<String,String> map);
}
