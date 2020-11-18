package com.tjian.dao;

import com.tjian.payment.PaymentVo;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao {

    int payment(PaymentVo paymentVo);
}
