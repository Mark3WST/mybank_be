package mybank_be.rest.service;

import org.springframework.transaction.annotation.Transactional;

import mybank_be.rest.entity.User;
import mybank_be.rest.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userDao.register(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
