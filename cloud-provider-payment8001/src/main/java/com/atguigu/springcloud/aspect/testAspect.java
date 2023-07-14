package com.atguigu.springcloud.aspect;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Aspect
@Component
@Slf4j
public class testAspect {

    @Pointcut("execution(* com.atguigu.springcloud.controller..*.*(..))")
    public void opRecordPoint() {
    }

    @Around("opRecordPoint()")
    public Object aroundManage(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
        String body = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
        String requestURI = requestWrapper.getRequestURI();
        log.info("URI is [{}],request body is [{}],param is [{}].", requestURI, body, JSON.toJSONString(requestWrapper.getParameterMap()));

        Object result = joinPoint.proceed();
        return result;
    }
}
