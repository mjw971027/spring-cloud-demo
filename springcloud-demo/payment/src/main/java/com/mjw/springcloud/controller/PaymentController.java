package com.mjw.springcloud.controller;

import com.mjw.springcloud.entities.CommonResult;
import com.mjw.springcloud.entities.Payment;
import com.mjw.springcloud.service.PaymentService;
import com.mjw.springcloud.service.impl.PaymentServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")

@Slf4j
public class PaymentController {
    @Resource
    private PaymentServiceimpl paymentService;

    @Value("${server.port}")
    private String serverport;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果：{result}");
        if(result>0){
            return new CommonResult(200,"插入成功,serverport"+serverport,result);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果：{payment}");
        if(payment!=null){
            return new CommonResult(200,"查询成功,serverport"+serverport,payment);
        }else {
            return new CommonResult(444,"无记录");
        }
    }
    @GetMapping("/discovery")
    public Object discovery(){
        //获取服务列表
        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("****element: "+element);
        }
        //获取具体服务下的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"+instance.getUri());
        }
        return this.discoveryClient;
    }

}

