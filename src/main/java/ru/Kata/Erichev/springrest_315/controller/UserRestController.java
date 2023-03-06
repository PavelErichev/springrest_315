package ru.Kata.Erichev.springrest_315.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Kata.Erichev.springrest_315.entity.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @GetMapping("/userAuth")
    public ResponseEntity<User> showAuthUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }
}