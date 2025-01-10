package com.test.springbootproject01.config;
import com.test.springbootproject01.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//@Configuration注解表示当前类是一个配置类
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    //注入拦截器对象
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    //注册/添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                //添加拦截器拦截路径
                .addPathPatterns("/**")
                //除了/login以外的路径都要被拦截
                .excludePathPatterns("/login");
    }
}
