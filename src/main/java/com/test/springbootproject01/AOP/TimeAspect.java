package com.test.springbootproject01.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {
    /*@Around("execution(* com.test.springbootproject01.Service.*.*(..))")*/
    @Around("com.test.springbootproject01.AOP.TestAOP.pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //方法启动时间
        long startTime = System.currentTimeMillis();
        //执行方法
        Object result = joinPoint.proceed();
        //方法结束时间
        long endTime = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行时间为"+(endTime - startTime) + "ms");
        return result;
    }
}
