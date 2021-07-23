package com.dms.config.security.web;

import com.dms.config.security.jwt.JwtAuthenticationFilter;
import com.dms.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring eb Security Config.
 *
 * @author NOH
 * @since 1.0
 *
 */
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtTokenProvider jwtTokenProvider;

  // authenticationManager를 Bean 등록합니다.
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .httpBasic().disable() // rest api 만을 고려하여 기본 설정은 해제하겠습니다.
        .csrf().disable() // csrf 보안 토큰 disable처리.
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 역시 사용하지 않습니다.
        .and()
        .authorizeRequests() // 요청에 대한 사용권한 체크
        .antMatchers(HttpMethod.GET, "/open-api/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().permitAll() // 그외 나머지 요청은 누구나 접근 가능
        .and()
        .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
            UsernamePasswordAuthenticationFilter.class);
  }

}