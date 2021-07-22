package com.dms.config.security.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring eb Security Config.
 *
 * @author  NOH
 * @since   1.0
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/resources/static");
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/open-api/**").permitAll()
        .antMatchers("/api/**").authenticated();

    http.csrf().disable();
  }


}
