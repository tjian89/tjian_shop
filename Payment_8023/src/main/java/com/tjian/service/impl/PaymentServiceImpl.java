package com.tjian.service.impl;

import com.tjian.dao.PaymentDao;
import com.tjian.payment.PaymentVo;
import com.tjian.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int payment(PaymentVo paymentVo) {
        return paymentDao.payment(paymentVo);
    }
}
