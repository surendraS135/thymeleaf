package com.work.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

public class SecurityConfig   {
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) -> authorize
                .anyRequest().permitAll()
            );
          //  .httpBasic(withDefaults()).oauth2Login(withDefaults());
        return http.build();
    }

    @Bean
	public UserDetailsService userDetailsService() {
		User.UserBuilder builder = User.builder();
		UserDetails user = builder.username("user").password("password").roles("USER").build();
		UserDetails admin = builder.username("admin").password("password").roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
    @Bean
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
    
}
