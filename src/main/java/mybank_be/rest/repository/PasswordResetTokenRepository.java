package mybank_be.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mybank_be.rest.entity.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
