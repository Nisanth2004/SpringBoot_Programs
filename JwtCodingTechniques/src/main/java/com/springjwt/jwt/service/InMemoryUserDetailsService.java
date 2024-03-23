package com.springjwt.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InMemoryUserDetailsService implements UserDetailsService
{
    private List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users)
    {
        this.users = users;
    }

    // check the usrname
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(u->u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(()->new UsernameNotFoundException("User not found "));
    }
}
