package mybank_be.rest.dao;

import mybank_be.rest.entity.User;

public interface UserDao {
    User register(User newUser);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByResetToken(String resetToken);

    void save(User user);
}
