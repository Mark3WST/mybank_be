package mybank_be.rest.dao;

import org.springframework.stereotype.Repository;

import mybank_be.rest.entity.User;
import mybank_be.rest.userRepository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

@Repository
@Profile("db")
public class UserDaoImpl implements UserDao{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
