package mybank_be.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mybank_be.rest.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
