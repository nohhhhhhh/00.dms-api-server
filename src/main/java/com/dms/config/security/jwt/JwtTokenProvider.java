package com.dms.config.security.jwt;

import com.dms.api.service.common.impl.SecurityUserDetailServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

  @Autowired
  SecurityUserDetailServiceImpl customUserDetailsService;

  @Value("${jwt.secret}")
  private String SECRET_KEY;

  @Value("${app.name}")
  private String ISSUER;

  @Value("${jwt.token-validity-seconds}")
  private int TOKEN_VALIDITY_SECONDS;

  private final UserDetailsService userDetailsService;

  public String createToken(String userId) {
    Claims claims = Jwts.claims().setSubject(userId);
    claims.put("username",userId);
    /*claims.put("roles", roles); // 정보는 key / value 쌍으로 저장된다.*/
    Date expireTime = new Date();
    Long test = 1000 * 60L * 60L * 2L;
    expireTime.setTime(expireTime.getTime() + test);

    Map<String, Object> header = new HashMap<>();
    header.put("alg", "RS256");
    header.put("typ", "JWT");
    Date now = new Date();
    return Jwts.builder()
        .setHeader(header)
        .setClaims(claims)
        .setIssuedAt(now)
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .setExpiration(expireTime)
        .setIssuer(ISSUER)
        .setId(UUID.randomUUID().toString())
        .compact();
  }

  public Authentication getAuthentication(String token) {
    UserDetails userDetails = customUserDetailsService.loadUserByUsername(this.getUserPk(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

  public String getUserPk(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
  }

  public String getUserPk(String token, PrivateKey privateKey) {
    return Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token).getBody().getSubject();
  }

  public String resolveToken(HttpServletRequest request) {
    return request.getHeader("userToken");
  }

  public boolean validateToken(String jwtToken) {
    try {
      Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken);
      return !claims.getBody().getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

  public boolean validateToken(String jwtToken, PrivateKey privateKey) {
    try {
      Jws<Claims> claims = Jwts.parser().setSigningKey(privateKey).parseClaimsJws(jwtToken);
      return !claims.getBody().getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

}
