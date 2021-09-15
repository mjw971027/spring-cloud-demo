package com.mjw.springcloud.controller;

import cn.hutool.core.lang.UUID;
import com.mjw.springcloud.entities.CommonResult;
import com.mjw.springcloud.entities.Payment;
import com.mjw.springcloud.service.PaymentService;
import com.mjw.springcloud.service.impl.PaymentServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentzk(){
        return "springcloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}

