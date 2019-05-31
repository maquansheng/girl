package com.ma.Aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/*
使用aop处理请求
 */
@Aspect
@Component
public class HttpAcpect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAcpect.class);

    @Pointcut("execution(public * com.ma.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefor() {
        logger.info("1111111111===================================================================");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
    }

    @After("log()")
    public void doAfter() {
        logger.info("2222222222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterRuning(Object object) {
        logger.info("response={}", object.toString());
    }
}
