package com.test.springbootproject01;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Map;

/*@SpringBootTest*/
class SpringBootProject01ApplicationTests {

    @Test
    public void jwtBuilder() {
        //创建键值对，用户名和密码
        /*Map<String, Object> claims = Jwts.claims();
        claims.put("id", 1);
        claims.put("name", "tom");*/
        Claims claims = Jwts.claims();
        claims.put("id",1);
        claims.put("name", "tom");
        String jwtString=Jwts.builder()
                //设置编码和解码的算法是HS256，秘钥是itheima
                .signWith(SignatureAlgorithm.HS256, "itheima")
                //设置jwt令牌的内容
                .setClaims(claims)
                //设置jwt令牌的时效1小时，3600是毫秒，要乘1000，还有一小时过期
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                //把令牌信息转化为String类型
                .compact();
        System.out.println(jwtString);
    }
    @Test
    public void jwtParser() {
        Claims claims =Jwts.parser()
                //输入秘钥
                .setSigningKey("itheima")
                //给jwt令牌解码
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwibmFtZSI6InRvbSIsImV4cCI6MTczMzM4OTM3Nn0.vd8c0VxoXQ4Jy1JTr1NSZQ6cRwD7rmSZLe-JONERoh8")
                //获取claims对象
                .getBody();
        System.out.println(claims);
    }

}
