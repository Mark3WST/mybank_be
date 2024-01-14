package mybank_be.rest.dao;

import java.util.List;
import java.util.Optional;

import mybank_be.rest.entity.Wallet;

public interface WalletDao {
    Wallet createWallet(Wallet wallet);

    List<Wallet> getAllWallets();

    Optional<Wallet> findById(Long id);

    void delete(Wallet wallet);
}
