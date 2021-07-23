package com.dms.config.security.jwt;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

  @Value("${jwt.secret}")
  private String secretKey;

  @Value("${jwt.token-validity-seconds}")
  private String TOKEN_VALIDITY_SECONDS;

  // 토큰 유효시간 1달
  private final long tokenValidTime = 60 * 30 * 1000L;

  private final UserDetailsService userDetailsService;

  // JWT 토큰 생성
  public String createToken(String userId) {
    Claims claims = Jwts.claims().setSubject(userId); // JWT payload 에 저장되는 정보단위
    /*claims.put("roles", roles); // 정보는 key / value 쌍으로 저장된다.*/
    Map<String, Object> header = new HashMap<>();
    header.put("alg", "RS256");
    header.put("typ", "JWT");
    Date now = new Date();
    return Jwts.builder()
        .setHeader(header) // 알고리즘과 토큰 타입을 헤더에 넣어줌
        .setClaims(claims) // 유저의 이름(userPk)등이 담겨있음
        .setIssuedAt(now) // 토큰 발행 시간 정보 iat
        .signWith(SignatureAlgorithm.HS512, secretKey)  // 사용할 암호화 알고리즘과
        .setIssuer("dev_koo")
        .setId(UUID.randomUUID().toString())
        // signature 에 들어갈 secret값 세팅
        .compact();
  }

  // JWT 토큰에서 인증 정보 조회
  public Authentication getAuthentication(String token) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

  // 토큰에서 회원 정보 추출
  public String getUserPk(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }

  // 임시로 세션에 있는 개인키까지 던져준다.
  public String getUserPk(String token, PrivateKey privateKey) {
    return Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token).getBody().getSubject();
  }

  // Request의 Header에서 token 값을 가져옵니다. "JWT" : "TOKEN값'
  public String resolveToken(HttpServletRequest request) {
    return request.getHeader("JWT");
  }

  // 토큰의 유효성 + 만료일자 확인
  public boolean validateToken(String jwtToken) {
    try {
      Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
      return !claims.getBody().getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

  // 토큰의 유효성 + 만료일자 확인
  public boolean validateToken(String jwtToken, PrivateKey privateKey) {
    try {
      Jws<Claims> claims = Jwts.parser().setSigningKey(privateKey).parseClaimsJws(jwtToken);
      return !claims.getBody().getExpiration().before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

}
