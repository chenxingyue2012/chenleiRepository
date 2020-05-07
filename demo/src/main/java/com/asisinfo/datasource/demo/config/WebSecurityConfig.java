package com.asisinfo.datasource.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/index.html")
                .antMatchers("/getRobotInfo/**");
    }
    */

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/welcome.html", "/hello/**", "/getRobotInfo/**", "/modifyRobotInfo/**")
                .permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/hello/v1");
    }
}
