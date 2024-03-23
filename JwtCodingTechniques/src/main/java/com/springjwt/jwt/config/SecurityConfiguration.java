package com.springjwt.jwt.config;

import com.springjwt.jwt.service.InMemoryUserDetailsService;
import com.springjwt.jwt.service.UserMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration
{
    @Autowired
    private UserMemoryService userMemoryService;
   @Bean
    public PasswordEncoder passwordEncoder()
   {
       return NoOpPasswordEncoder.getInstance();
   }

   @Bean
    public UserDetailsService userDetailsService()
   {
       // passing list of users
    return new InMemoryUserDetailsService(userMemoryService.users());
   }

   // Authentication Provider
   @Bean
    public AuthenticationManager authenticationManager(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService)
   {
       var daoAuthenticationProvider=new DaoAuthenticationProvider();
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
       daoAuthenticationProvider.setUserDetailsService(userDetailsService);
       return new ProviderManager(daoAuthenticationProvider);

   }

   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
   {
       httpSecurity.csrf(c-> c.disable());
       httpSecurity.authorizeHttpRequests(request->request.requestMatchers("/home","/login-page")
               .permitAll()
               .anyRequest()
               .authenticated());
           httpSecurity.formLogin(form -> form
                   .loginPage("/login-page")
                   .loginProcessingUrl("/login-page") // Specify the URL for processing the login form
                   .defaultSuccessUrl("/home", true));
           return httpSecurity.build();

   }
}
