package ru.Kata.Erichev.springrest_315.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Kata.Erichev.springrest_315.dto.UserDTO;
import ru.Kata.Erichev.springrest_315.entity.User;
import ru.Kata.Erichev.springrest_315.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("admin/list")
    public ResponseEntity<List<User>> showAllUser() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("admin/{id}")
    public ResponseEntity<User> getUserId(@PathVariable("id") long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("admin")
    public ResponseEntity<User> addNewUser(@RequestBody UserDTO userDTO, String[] role) {
        User user = new User(userDTO);
        userService.saveUser(user, role);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PatchMapping("admin")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO, String[] role) {
        User user = new User(userDTO);
        userService.saveUser(user, role);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}