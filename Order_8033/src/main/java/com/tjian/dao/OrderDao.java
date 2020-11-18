package com.tjian.dao;

import com.tjian.order.OrderPo;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    void insertOrder(OrderPo order);

    int deleteOrder(Long orderId);

    int updateOrder(OrderPo order);

    OrderPo getOrder(Long orderId);
}
