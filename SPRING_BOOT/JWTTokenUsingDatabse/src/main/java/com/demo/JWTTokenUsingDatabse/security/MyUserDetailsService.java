package com.demo.JWTTokenUsingDatabse.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.JWTTokenUsingDatabse.beans.MyUser;
import com.demo.JWTTokenUsingDatabse.dao.LoginDao;

//import com.example.JWTSecurityUsingdatabse.dao.LoginDao;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginDao repo;

    //this method converts MyUser object which has data from database to
    //spring security class UserDetails
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser u = repo.findByUname(username);
        System.out.println("in loadbyusername");
        System.out.println(u);
        if (u == null)
            throw new UsernameNotFoundException("User Not Found");

        return org.springframework.security.core.userdetails.User
                .withUsername(u.getUname())
                .password(u.getPassword())
                .roles(u.getRole())   // ⭐ ROLE_ADMIN or ROLE_USER
                .build();
    }
}