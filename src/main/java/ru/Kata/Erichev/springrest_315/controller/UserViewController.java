package ru.Kata.Erichev.springrest_315.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserViewController {

    @GetMapping
    public String userInfo() {
        return "user";
    }

    /*private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/getUser")
    @ResponseBody
    public ResponseEntity<User> showUser(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        return "user";
    }*/

    /*@GetMapping("/userAuth")
    @ResponseBody
    public ResponseEntity<User> showUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public String userInfo() {
        return "user";
    }*/

    /*@GetMapping("/admin")
    public String admin(ModelMap modelMap, Principal principal){
        modelMap.addAttribute("user", userRepository.findByEmail(principal.getName()));
        return "admin";
    }*/

    /*@GetMapping("/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/userAdmin")
    public String getUserAdmin(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "userAdmin";
    }*/
}