package com.mjw.springcloud.service.impl;

import com.mjw.springcloud.dao.PaymentDao;
import com.mjw.springcloud.entities.Payment;
import com.mjw.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PaymentServiceimpl  implements PaymentService {

    @Autowired
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}
