package com.argusoft.appointment.utils.security.jwt;


import com.argusoft.appointment.utils.security.config.MyUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("tune jo na kaha me wo sunta raha")
    private String jwtSecret;

//    @Value("#{new Integer('Integer.parse(${app.jwtExpirationMs})')}")
    @Value("86400000")
    private Integer jwtExpirationMs;

    // This is used for generating JwtToken
    public String generateJwtToken(Authentication authentication) {

        MyUserDetails userPrincipal = (MyUserDetails) authentication.getPrincipal();

        System.out.println(new Date());
        System.out.println(new Date((new Date()).getTime() + jwtExpirationMs));

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    // validating token got from response
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception e){
            logger.error("error is "+e.getMessage());
        }

        return false;
    }
}
