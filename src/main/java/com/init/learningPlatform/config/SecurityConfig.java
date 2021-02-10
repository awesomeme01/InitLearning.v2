package com.init.learningPlatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
@CrossOrigin(origins ="*")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/api").permitAll()
//                .antMatchers("/user").access("hasRole('USER')")
//                .antMatchers("/user/create").access("hasRole('ADMIN')")
//                .antMatchers("/user/delete").access("hasRole('ADMIN')")
//                .antMatchers("/course/create").access("hasRole('ADMIN')")
//                .antMatchers("/course/delete").access("hasRole('ADMIN')")
                .and()
                .httpBasic()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .csrf()
                .disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, is_active from user_init_1 where username = ?")
                .authoritiesByUsernameQuery("select u.username, ur.role as role from user_init_1 u inner join user_role_init_1 ur on u.id = ur.user_id where u.username = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
