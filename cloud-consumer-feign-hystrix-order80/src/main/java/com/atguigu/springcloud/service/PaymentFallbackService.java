package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component //必须加 //必须加 //必须加
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService-paymentInfo_OK，请稍后再试，/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService-paymentInfo_TimeOut，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
