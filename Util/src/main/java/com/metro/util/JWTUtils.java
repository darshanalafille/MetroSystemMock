package com.metro.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private static String secret = "AMMA_OKA";

    public static String generateToken(Long userId,String nic){
        Map<String,Object> claimsMap = getClaimsMap(userId,nic);
        return Jwts.builder().setClaims(claimsMap).setSubject(nic).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512,secret).compact();
    }

    private static Map<String,Object> getClaimsMap(Long userId,String nic){
        Map<String,Object> claimsMap = new HashMap<>();
        claimsMap.put("USER_ID",userId);
        claimsMap.put("NIC",nic);
        return claimsMap;
    }

    public static Claims getTokenClaims(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }



}
