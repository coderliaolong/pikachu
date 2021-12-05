package com.liaolong.pikachu.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LiaoLong
 * @date 2021-12-05 14:17
 */
@Component
@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("----日志记录生成前------");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getDeclaringTypeName() + "." + signature.getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request: {}", requestLog);
    }

    /**
     * execution表达式和java中的包级管理方式有关系,java中,包下的子包和父包是没有任何关系的
     * 如果要应用到某一个类,那这个包名就必须要精确到该类的全包名
     */
    @Pointcut("execution(* com.liaolong.pikachu.controller.*.*(..))")
    public void log() {

    }


    @After("log()")
    public void doAfter() {
        logger.info("-------日志记录后---------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("-------" + result + "----------");
    }

    @Data
    @AllArgsConstructor
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
