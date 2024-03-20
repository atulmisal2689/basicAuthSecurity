package com.jbk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter
{
	    @Override
	    protected void configure(HttpSecurity http) throws Exception 
	    {
		 
		  http
		  .csrf().disable()
		  .authorizeRequests()
		  .antMatchers("/public/**").hasRole("Normal")
		  .antMatchers("/users/**").hasRole("Admin")
		  .anyRequest()
		  .authenticated()
		  .and()
		  .httpBasic();
	    }
	 
	 @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception 
     {
         //auth.inMemoryAuthentication().withUser("john").password("john").roles("Normal");
        // auth.inMemoryAuthentication().withUser("roshni").password("roshni").roles("Admin");
     
		auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("john")).roles("Normal");
	    auth.inMemoryAuthentication().withUser("roshni").password(this.passwordEncoder().encode("roshni")).roles("Admin");
	    auth.inMemoryAuthentication().withUser("atul").password(this.passwordEncoder().encode("atul")).roles("Normal","Admin");
	     
     
     }
	 
	 @SuppressWarnings("deprecation")
		@Bean
	     public BCryptPasswordEncoder passwordEncoder() 
	     {
	         //return NoOpPasswordEncoder.getInstance();
		     return new BCryptPasswordEncoder(10);
	     }
	 
	
}
