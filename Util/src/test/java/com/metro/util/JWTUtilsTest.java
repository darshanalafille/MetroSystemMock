package com.metro.util;

import io.jsonwebtoken.Claims;
import org.junit.Test;
import static org.junit.Assert.*;

public class JWTUtilsTest {

    @Test
    public void testJwtOperations(){
        String nic = "9503440170V";
        String jwtToken = JWTUtils.generateToken(100L,nic);
        assertNotNull(jwtToken);
        System.out.println(jwtToken);
        Claims claims = JWTUtils.getTokenClaims(jwtToken);
        assertEquals(nic,claims.get("NIC"));
    }

    @Test
    public void testJwtOperationsModifiedToken(){
        String nic = "9503440170V";
        String jwtToken = JWTUtils.generateToken(100L,nic);
        assertNotNull(jwtToken);
        System.out.println(jwtToken);
        jwtToken = jwtToken + "MODIFIED";
        try {
            Claims claims = JWTUtils.getTokenClaims(jwtToken);
            assertEquals(nic,claims.get("NIC"));
        } catch (Exception e) {
            assertEquals("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.",
                    e.getMessage());
            e.printStackTrace();
        }
    }

}
