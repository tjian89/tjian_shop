package com.tjian.dao;

import com.tjian.order.OrderProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductDao {

    int addOrderProduct(@Param("orderId") Long orderId, @Param("orderProducts") List<OrderProduct> orderProducts);

    int deleteOrderProduct(Long orderId);

    List<OrderProduct> getOrderProduct(Long orderId);
}
