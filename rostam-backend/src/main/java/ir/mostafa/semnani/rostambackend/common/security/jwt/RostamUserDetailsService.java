package ir.mostafa.semnani.rostambackend.common.security.jwt;


import ir.mostafa.semnani.rostambackend.common.security.user.User;
import ir.mostafa.semnani.rostambackend.common.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class RostamUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getUserRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return authorities;
    }



}
