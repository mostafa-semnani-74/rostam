package ir.mostafa.semnani.rostambackend.controller;

import ir.mostafa.semnani.rostambackend.common.Exception.ResourceNotFoundException;
import ir.mostafa.semnani.rostambackend.model.entity.User;
import ir.mostafa.semnani.rostambackend.model.repository.UserDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserDA userDA;

    @GetMapping("/rest/user")
    List<User> restFindAllUser() { return userDA.findAll(); }

    @GetMapping("/rest/user/{id}")
    ResponseEntity<User> restGetUserById(@PathVariable Long id) {
        User user = userDA.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id) );
        return ResponseEntity.ok(user);
    }

    @PostMapping("/rest/user")
    User restCreateUser(@RequestBody User user) { return userDA.save(user); }

    @PutMapping("/rest/user/{id}")
    ResponseEntity<User> restUpdateUser(@RequestBody User user, @PathVariable Long id) {
        User userForUpdate = userDA.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("user not exist with id :" + id) );

        userForUpdate.setUsername(user.getUsername());
        userForUpdate.setPassword(user.getPassword());
        userForUpdate.setStatus(user.getStatus());

        userDA.save(userForUpdate);
        return ResponseEntity.ok(userForUpdate);
    }

    @DeleteMapping("/rest/user/{id}")
    ResponseEntity<Map<String , Boolean>> restDeleteUser(@PathVariable Long id) {
        User user = userDA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id) );

        user.setStatus(0);
        userDA.save(user);

        Map<String , Boolean> responseMap = new HashMap<>();
        responseMap.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(responseMap);
    }

}
