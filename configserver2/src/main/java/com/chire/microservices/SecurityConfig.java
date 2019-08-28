package com.chire.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("SUPERUSER","ADMIN");

    }

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/encrypt**").hasAnyRole("SUPERUSER","ADMIN")
                .antMatchers("/decrypt**").hasAnyRole("SUPERUSER","ADMIN")
                .antMatchers("/chire-dev/**").hasAnyRole("SUPERUSER")
                .anyRequest().permitAll() .and().csrf() .disable();
    }
}