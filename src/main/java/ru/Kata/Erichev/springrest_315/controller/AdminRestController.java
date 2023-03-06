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

   /* @GetMapping
    public String showAllUser(@AuthenticationPrincipal User user, Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUs", allUsers);
        model.addAttribute("user", user);
        return "admin";
    }

    @GetMapping("/user-create")
    public String addNewUser(@AuthenticationPrincipal User user, Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(value = "roless") String[] role) {
        userService.saveUser(user, role);
        return "redirect:/admin";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PutMapping(value = "/user-update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "roless") String[] role) {
        userService.saveUser(user, role);
        return "redirect:/admin";
    }*/
}