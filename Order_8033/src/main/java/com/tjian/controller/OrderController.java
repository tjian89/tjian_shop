package com.tjian.controller;

import com.tjian.order.OrderPo;
import com.tjian.entity.ResponseResult;
import com.tjian.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/insert/order")
    public ResponseResult<Long> insertOrder(@RequestBody OrderPo order){
        Long orderId = orderService.insertOrder(order);
        return ResponseResult.successWithResult(orderId);
    }

    @PostMapping("/delete/order/{id}")
    public ResponseResult<Integer> deleteOrder(@PathVariable("id") Long orderId){
        int deleteNum = orderService.deleteOrder(orderId);
        return ResponseResult.successWithResult(deleteNum);
    }

    @PostMapping("/update/order")
    public ResponseResult<Integer> updateOrder(@RequestBody OrderPo order){
        int updateNum =  orderService.updateOrder(order);
        return ResponseResult.successWithResult(updateNum);
    }

    @PostMapping("/get/order/{id}")
    public ResponseResult<OrderPo> getOrder(@PathVariable("id") Long orderId){
        OrderPo order =  orderService.getOrder(orderId);
        return ResponseResult.successWithResult(order);
    }
}
