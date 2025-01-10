package com.test.springbootproject01.pojo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtHelper {
    private String key = "Lucius";
    private Integer Time=3600*1000;
    public String getJwt(Claims claims){
        String jwt= Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256,key)
                .setExpiration(new Date(System.currentTimeMillis()+Time))
                .compact();
        return jwt;
    }
    public Claims parseJwt(String jwt){
        Claims claims=Jwts.parser()
                //输入秘钥
                .setSigningKey(key)
                //给jwt令牌解码
                .parseClaimsJws(jwt)
                //获取claims对象
                .getBody();
        return claims;
    }
}
