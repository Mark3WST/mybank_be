package mybank_be.rest.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mybank_be.rest.entity.User;
import mybank_be.rest.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User newUser = userService.register(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {

        User oauthUser = userService.login(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {

            return "redirect:/";

        } else {
            return "redirect:/login";

        }
    }

}
