package com.test.springbootproject01.exception;

import com.test.springbootproject01.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//同时包含@ControllerAdvice和@ResponseBody
//@ControllerAdvice 是Spring框架中用于处理全局异常的一个注解。
//@ResponseBody可以将返回结果转化为JSON，@RestController也包含这个注解
@RestControllerAdvice
public class GlobleEceptionHandler {
    //统一处理所有异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        //打印异常信息
        e.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }
}