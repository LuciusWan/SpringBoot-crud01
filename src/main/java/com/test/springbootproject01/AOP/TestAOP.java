package com.test.springbootproject01.AOP;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Slf4j
//把AOP中的方法和原方法打包好后形成一个新的方法，动态代理方法，运行的时候运行的就是加强方法
@Component
@Aspect
public class TestAOP {
    @Pointcut("execution(* com.test.springbootproject01.Service.*.*(..))")
    public void pt(){}
    //方法启动之前调用
    @Before("pt()")
    public void Before() {
        log.info("BeforeAOP");
    }
    //环绕目标方法使用
    @Around("pt()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AroundBefore");
        Object result = joinPoint.proceed();
        log.info("AroundAfter");
        return result;
    }
    //方法启动之后调用
    @After("pt()")
    public void After() {
        log.info("AfterAOP");
    }
    //方法返回值后调用
    @AfterReturning("pt()")
    public void AfterReturning() {
        log.info("AfterReturningAOP");
    }
    //方法抛出异常后使用
    @AfterThrowing("pt()")
    public void AfterThrowing() {
        log.info("AfterThrowingAOP");
    }
}
