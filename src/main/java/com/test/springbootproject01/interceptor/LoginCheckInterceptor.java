package com.test.springbootproject01.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.test.springbootproject01.pojo.JwtHelper;
import com.test.springbootproject01.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标方法运行前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1获取请求路径
        String url = request.getRequestURI();
        log.info("拦截到请求：{}",url);
        //如果是登录请求，放行
        if(url.equals("/login")){
            log.info("登录放行");
            return true;
        }
        //2判断是否登录
        String jwt=request.getHeader("token");
        if(jwt==null){
            log.info("未登录，拦截");
            Result error=Result.error("NOT_LOGIN");
            String notlogin=JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            //返回false不放行
            return false;
        }
        JwtHelper jwtHelper=new JwtHelper();
        //3判断jwt是否合法
        //解析jwt令牌时，如果解析失败，抛出异常，捕获异常，返回错误信息，如果解析成功，就可以放行
        try {
            jwtHelper.parseJwt(jwt);
        } catch (Exception e) {
            log.info("jwt无效");
            Result error=Result.error("NOT_LOGIN");
            String notlogin=JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        log.info("jwt有效");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
