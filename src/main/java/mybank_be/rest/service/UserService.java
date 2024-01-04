package mybank_be.rest.service;

import mybank_be.rest.entity.User;

public interface UserService {
    User register(User newUser);

    User findByUsername(String username);

    User login(String username, String password);
}
