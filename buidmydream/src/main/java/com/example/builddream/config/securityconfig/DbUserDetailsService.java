package com.example.builddream.config.securityconfig;

import com.example.builddream.pojo.mybatisdo.UserDo;
import com.example.builddream.service.UserService;
import com.example.builddream.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbUserDetailsService implements UserDetailsService {
    private  final UserService userService;

    @Autowired
    DbUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDo userDo = userService.getUserByName(username);
        if (userDo == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        List<String> userRoles = userService.getUserRoles(username);
        for (String userRole : userRoles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(userRole));
        }
        return new org.springframework.security.core.userdetails.User(userDo.getUsername(), userDo.getPassword(), simpleGrantedAuthorities);
    }
}
