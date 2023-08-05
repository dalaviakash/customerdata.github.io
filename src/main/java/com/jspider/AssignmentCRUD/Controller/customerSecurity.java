package com.jspider.AssignmentCRUD.Controller;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class customerSecurity extends WebSecurityConfigurerAdapter {
    //authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser((user.username("test@sunbasedata.com").password("Test@123").roles("ADMIN")));
    }
    //Authorization

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/index").hasRole("ADMIN")
                .and().formLogin();
    }
}
