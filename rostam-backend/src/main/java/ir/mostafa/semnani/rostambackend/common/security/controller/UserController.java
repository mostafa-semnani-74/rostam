package ir.mostafa.semnani.rostambackend.common.security.controller;

import ir.mostafa.semnani.rostambackend.common.security.user.User;
import ir.mostafa.semnani.rostambackend.common.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/rest/user")
    List<User> restFindAllUser() { return userService.findAll(); }

    @GetMapping("/rest/user/{id}")
    ResponseEntity<User> restGetUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/rest/user")
    ResponseEntity<User> restCreateUser(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/rest/user/{id}")
    ResponseEntity<User> restUpdateUser(@RequestBody User user, @PathVariable Long id) {
        User userForUpdate = userService.update(user , id);
        return ResponseEntity.ok(userForUpdate);
    }

    @DeleteMapping("/rest/user/{id}")
    ResponseEntity<Map<String , Boolean>> restDeleteUser(@PathVariable Long id) {
        userService.findById(id);
        userService.delete(id);

        Map<String , Boolean> responseMap = new HashMap<>();
        responseMap.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(responseMap);
    }

}
