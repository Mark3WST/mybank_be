package mybank_be.rest.dao;

import java.util.List;

import mybank_be.rest.entity.Wallet;

public interface WalletDao {
    Wallet createWallet(Wallet wallet);
    List<Wallet> getAllWallets();
}
