package mybank_be.rest.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import mybank_be.rest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
