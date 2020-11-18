package com.tjian.controller;

import com.alibaba.fastjson.JSONObject;
import com.tjian.entity.ResponseResult;
import com.tjian.payment.PaymentVo;
import com.tjian.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/money")
    public ResponseResult<String> payment(@RequestBody PaymentVo paymentVo){
        String paymentId = UUID.randomUUID().toString().replaceAll("-", "");
        paymentVo.setPaymentId(paymentId);
        paymentVo.setPaymentTime(new Date());
        int result = paymentService.payment(paymentVo);
        return ResponseResult.successWithResult(paymentId);
    }

}
