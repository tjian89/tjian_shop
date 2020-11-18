package com.tjian.controller;

import com.alibaba.fastjson.JSONObject;
import com.tjian.entity.ResponseResult;
import com.tjian.order.OrderPo;
import com.tjian.order.OrderProduct;
import com.tjian.payment.PaymentVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class BuyProductController {

    private final String orderUrl = "http://ORDER-SERVICE";
    private final String paymentUrl = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/buy")
    public ResponseResult<OrderPo> buyProduct(@RequestBody List<OrderProduct> products){

        OrderPo orderPo = new OrderPo();
        orderPo.setProducts(products);
        BigDecimal orderMoney = new BigDecimal(0);

        for (OrderProduct product:products) {
            double productPrice = product.getProductPrice();
            int productNum = product.getProductNum();
            BigDecimal totalPrice = new BigDecimal(productPrice).multiply(new BigDecimal(productNum));
            orderMoney = orderMoney.add(totalPrice);

        }
        orderPo.setOrderMoney(orderMoney.doubleValue());
        orderPo.setOrderStatus(0);
        orderPo.setOrderTime(new Date());

        ResponseEntity<JSONObject> repsonse = restTemplate.postForEntity(orderUrl + "/order/insert/order", orderPo, JSONObject.class);
        if(200 == repsonse.getStatusCodeValue()){
            JSONObject body = repsonse.getBody();
            Long orderId = body.getLong("result");
            orderPo.setOrderId(orderId);
        }

        PaymentVo paymentVo = new PaymentVo();
        paymentVo.setOrderId(orderPo.getOrderId());
        paymentVo.setPaymentMoney(orderMoney.doubleValue());
        paymentVo.setPaymentType(1);
        ResponseEntity<JSONObject> paymentEntity = restTemplate.postForEntity(paymentUrl + "/payment/money", paymentVo, JSONObject.class);
        if(200 == paymentEntity.getStatusCodeValue()){
            JSONObject body = paymentEntity.getBody();
            String paymentId = body.getString("result");
            return ResponseResult.successWithResult(orderPo);
        }
        return ResponseResult.failed(500, "系统繁忙，请稍后重试");
    }
}
