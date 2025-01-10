package com.test.springbootproject01.Controller;
import com.test.springbootproject01.Service.EmpService;
import com.test.springbootproject01.pojo.Emp;
import com.test.springbootproject01.pojo.JwtHelper;
import com.test.springbootproject01.pojo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping
    public Result Login(@RequestBody Emp emp){
        log.info("{}请求登录",emp);
        Emp emp1=empService.login(emp);
        //如果查有此人就开始准备制作令牌
        if(emp1!=null){
            JwtHelper jh=new JwtHelper();
            Claims claims=new DefaultClaims();
            claims.put("id",emp1.getId());
            claims.put("username",emp1.getUsername());
            claims.put("password",emp1.getPassword());
            log.info("请求人用户名：{}",emp.getUsername());
            log.info("请求人密码{}",emp.getPassword());
            String jwt=jh.getJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("NOT_LOGIN");
    }
}
