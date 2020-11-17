package com.tjian.service;

import com.tjian.order.OrderPo;

public interface OrderService {

    Long insertOrder(OrderPo order);

    int deleteOrder(Long orderId);

    int updateOrder(OrderPo order);

    OrderPo getOrder(Long orderId);
}
