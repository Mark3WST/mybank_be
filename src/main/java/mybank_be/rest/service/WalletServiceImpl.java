package mybank_be.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybank_be.rest.entity.Wallet;
import mybank_be.rest.dao.WalletDao;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletDao walletDao;

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletDao.createWallet(wallet);
    }
    @Override
    public List<Wallet> getAllWallets() {
        return walletDao.getAllWallets();
    }
}
