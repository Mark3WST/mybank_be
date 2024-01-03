package mybank_be.rest.dao;

import mybank_be.rest.entity.User;

public interface UserDao {
    User register(User newUser);
    User findByUsername(String username);
}
