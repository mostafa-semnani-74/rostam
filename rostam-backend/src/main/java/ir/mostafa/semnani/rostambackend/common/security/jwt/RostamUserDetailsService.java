package ir.mostafa.semnani.rostambackend.common.security.jwt;

import ir.mostafa.semnani.rostambackend.common.security.user.User;
import ir.mostafa.semnani.rostambackend.common.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class RostamUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUsername(username);
        return new RostamUserDetails(user);
    }
}
