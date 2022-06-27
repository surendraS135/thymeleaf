package com.work.thymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfigurer extends SecurityConfigurerAdapter{
	


    private static final String[] BYPASS_AUTH_LIST = {
    		"/api/**",
    		"/**/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/h2-console",
            "/**/swagger-ui.html",
            "/webjars/**",
            "/**"
    }; 
    
  //  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        	http.authorizeRequests().antMatchers(BYPASS_AUTH_LIST).permitAll()
            .anyRequest().authenticated()
            .and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //	http.addFilterAfter(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

	

}
