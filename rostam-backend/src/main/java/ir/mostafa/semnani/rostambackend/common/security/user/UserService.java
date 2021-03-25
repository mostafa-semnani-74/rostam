package ir.mostafa.semnani.rostambackend.common.security.user;

import ir.mostafa.semnani.rostambackend.common.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDA userDA;

    @Autowired
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void create(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userDA.save(user); }
    @Transactional
    public void delete(Long id) { userDA.deleteById(id); }
    @Transactional
    public User update(User user , Long id) {
        User userForUpdate = userDA.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not exist with id :" + id) );

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userForUpdate.setUsername(user.getUsername());
        userForUpdate.setPassword(user.getPassword());
        userForUpdate.setStatus(user.getStatus());

        userDA.save(userForUpdate);
        return userForUpdate;
    }

    public List<User> findAll() { return userDA.findAll(); }
    public User findById(Long id) { return userDA.findById(id)
            .orElseThrow(() -> new UserNotFoundException("user not exist with id :" + id) ); }

    public User findByUsername(String username) { return userDA.getByUsername(username); }

}
