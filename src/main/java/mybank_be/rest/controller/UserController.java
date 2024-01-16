package mybank_be.rest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mybank_be.rest.entity.User;
import mybank_be.rest.service.PasswordResetService;
import mybank_be.rest.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private PasswordResetService passwordResetService;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User newUser = userService.register(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User oauthUser = userService.login(user.getUsername(), user.getPassword());

            // Generate a simple token (UUID) - for demonstration purposes only
            String token = UUID.randomUUID().toString();

            Map<String, Object> response = new HashMap<>();
            response.put("message", "User successfully authenticated");
            response.put("token", token); // Include the token in the response

            return ResponseEntity.ok(response);

        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            passwordResetService.createPasswordResetTokenForUser(user);
        }
        return ResponseEntity.ok("Reset link sent if the user exists");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        if (passwordResetService.validatePasswordResetToken(token)) {
            // Logic to reset password
            return ResponseEntity.ok("Password has been reset");
        }
        return ResponseEntity.badRequest().body("Invalid or expired token");
    }
}
