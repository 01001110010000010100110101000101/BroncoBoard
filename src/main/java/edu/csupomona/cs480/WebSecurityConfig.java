package edu.csupomona.cs480;
//Kevin is still messing with this security file if you un-comment you will have to uncomment the dependancy i created in pom file, but it will loop through user login page, need to figure out how to deal with
// html variables and how they are passed into java spring
//package edu.csupomona.cs480.controller;
//
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            //This will list what links are not going to be authenticate so we will have to put in the registration page which i used as sample
                .antMatchers("/send","/registration/**", "/chat","/cs480/ping", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
             //This is the login page i think we need to change the way to do login, 
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("select USER_ID, USER_PW, enabled from users where USER_ID=?")
        	.authoritiesByUsernameQuery("select USER_ID, ROLE from authorities where USER_ID=?");
            //.inMemoryAuthentication()
                //.withUser("user@cpp.edu").password("password").roles("USER");
    }
}