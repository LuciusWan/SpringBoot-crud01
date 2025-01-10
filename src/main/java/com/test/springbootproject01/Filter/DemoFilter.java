package com.test.springbootproject01.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
/*@WebFilter(urlPatterns = "/login")*/
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行了");
    }

    @Override//过滤器过滤请求,拦截到请求后调用，会调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求");
        //放行操作
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后的逻辑");
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法执行了");
    }
}
