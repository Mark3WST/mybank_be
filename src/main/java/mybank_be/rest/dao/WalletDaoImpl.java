package mybank_be.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import mybank_be.rest.entity.Wallet;
import mybank_be.rest.repository.WalletRepository;

@Repository
@Profile("db")
public class WalletDaoImpl implements WalletDao {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return walletRepository.findById(id);
    }

    @Override
    public void delete(Wallet wallet) {
        walletRepository.delete(wallet);
    }
}
