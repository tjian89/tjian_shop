package com.tjian.service.impl;

import com.tjian.dao.OrderDao;
import com.tjian.dao.OrderProductDao;
import com.tjian.order.OrderPo;
import com.tjian.order.OrderProduct;
import com.tjian.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderProductDao orderProductdao;

    @Override
    public Long insertOrder(OrderPo order) {
        //添加订单数据
        orderDao.insertOrder(order);
        Long orderId = order.getOrderId();
        //添加订单跟商品数据
        orderProductdao.addOrderProduct(orderId, order.getProducts());
        return orderId;
    }

    @Override
    public int deleteOrder(Long orderId) {
        orderProductdao.deleteOrderProduct(orderId);
        return orderDao.deleteOrder(orderId);
    }

    @Override
    public int updateOrder(OrderPo order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public OrderPo getOrder(Long orderId) {
        OrderPo order = orderDao.getOrder(orderId);
        List<OrderProduct> orderProducts = orderProductdao.getOrderProduct(orderId);
        order.setProducts(orderProducts);
        return order;
    }
}
