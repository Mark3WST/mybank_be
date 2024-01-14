package mybank_be.rest.service;

import java.util.List;

import mybank_be.rest.entity.Wallet;

public interface WalletService {
    Wallet createWallet(Wallet wallet);

    List<Wallet> getAllWallets();

    void deleteWallet(Long id);

    Wallet findById(Long id);

    Wallet updateWallet(Long id, Wallet walletDetails);
}
