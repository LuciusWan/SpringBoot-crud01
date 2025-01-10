package com.test.springbootproject01.Controller;

import com.test.springbootproject01.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    //设置cookies
    @GetMapping("/c1")
    public Result cookiel(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username","itheima"));
        return Result.success();
    }
    //获取cookies
    @GetMapping("/c2")
    public Result cookiel2(HttpServletRequest Request) {
        Cookie[] cookies = Request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("login_username")) {
                System.out.println("login_username"+cookies[i].getValue());
            }
        }
        return Result.success();
    }
    //cookies存储在服务端更方便
    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        session.setAttribute("loginUser","tom");
        return Result.success();
    }
    @GetMapping("/s2")
    public Result session2(HttpServletRequest Request) {
        HttpSession session = Request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        return Result.success(loginUser);
    }
}
