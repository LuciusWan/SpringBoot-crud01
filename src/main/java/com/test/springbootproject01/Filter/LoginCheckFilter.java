package com.test.springbootproject01.Filter;

import com.alibaba.fastjson.JSONObject;
import com.test.springbootproject01.pojo.JwtHelper;
import com.test.springbootproject01.pojo.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.http.HttpResponse;

@Slf4j
/*@WebFilter("/*")*/
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1获取请求路径
        String url = request.getRequestURI();
        log.info("拦截到请求：{}",url);
        if(url.equals("/login")){
            log.info("登录放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String jwt=request.getHeader("token");
        if(jwt==null){
            log.info("未登录，拦截");
            Result error=Result.error("NOT_LOGIN");
            String notlogin=JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }
        JwtHelper jwtHelper=new JwtHelper();
        try {
            jwtHelper.parseJwt(jwt);
        } catch (Exception e) {
            log.info("jwt无效");
            Result error=Result.error("NOT_LOGIN");
            String notlogin=JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return;
        }
        log.info("jwt有效，已登录过");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
