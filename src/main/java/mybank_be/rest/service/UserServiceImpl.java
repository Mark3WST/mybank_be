package mybank_be.rest.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybank_be.rest.dao.UserDao;
import mybank_be.rest.entity.Role;
import mybank_be.rest.entity.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public User register(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRoles(Collections.singleton(Role.USER)); // Assign default role
        return userDao.register(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return user;
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        User user = userDao.findByResetToken(token);
        if (user == null || user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Invalid or expired reset token");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null);
        user.setResetTokenExpiry(null);
        userDao.save(user);
    }

    @Transactional
    @Override
    public void createPasswordResetTokenForUser(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        user.setResetTokenExpiry(LocalDateTime.now().plusHours(1)); // Token expires in 1 hour
        userDao.save(user);

        sendPasswordResetEmail(user, token); // Send email with the token
    }

    @Transactional
    private void sendPasswordResetEmail(User user, String resetToken) {
        String resetUrl = "http://your-domain/auth/reset-password?token=" + resetToken; // URL for password reset page

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail()); // Assuming User entity has an email field
        message.setSubject("Password Reset Request");
        message.setText("To reset your password, click the link below:\n" + resetUrl);

        mailSender.send(message);
    }

}
