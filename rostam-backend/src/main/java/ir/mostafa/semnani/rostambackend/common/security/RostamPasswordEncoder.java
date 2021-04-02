package ir.mostafa.semnani.rostambackend.common.security;


import ir.mostafa.semnani.rostambackend.common.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RostamPasswordEncoder {

    @Autowired
    public static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static User encodeUserPassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return  user;
    }
}
