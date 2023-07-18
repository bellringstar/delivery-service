package com.example.jwt.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class JwtService {

    private static String secretKey = "java17springbootJWTTokenIssuemethod!@#$";
    //토큰 생성
    public String create(
            Map<String, Object> claims,
            LocalDateTime expireAt
    ){
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());
        // localDateTime 을 Date로
        var _expireAt = Date.from(expireAt.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setClaims(claims)
                .setExpiration(_expireAt)
                .compact();
    }

    //토큰 검증
    public void validation(String token){
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        var parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

        try{
            var result = parser.parseClaimsJws(token);
            result.getBody().entrySet().forEach(value ->
                    log.info("key : {}, value : {}", value.getKey(), value.getValue()));

        }catch (Exception e){
            if(e instanceof SignatureException){
                throw new RuntimeException("JWT Token Not Validation Exception");

            } else if(e instanceof ExpiredJwtException){
                throw new RuntimeException("JWT Token Expired Exception");
            } else {
                throw new RuntimeException("JWT Token Validation Exception");
            }
        }

    }


}
