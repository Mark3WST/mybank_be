package mybank_be.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybank_be.rest.dao.WalletDao;
import mybank_be.rest.entity.Wallet;
import mybank_be.rest.exception.ResourceNotFoundException;

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

    @Override
    public Wallet findById(Long id) {
        return walletDao.findById(id).orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    @Override
    public void deleteWallet(Long id) {
        Wallet wallet = findById(id);
        walletDao.delete(wallet);
    }

    @Override
    public Wallet updateWallet(Long id, Wallet walletDetails) {
        Wallet wallet = walletDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found for this id :: " + id));

        wallet.setName(walletDetails.getName());
        wallet.setBalance(walletDetails.getBalance());

        final Wallet updatedWallet = walletDao.createWallet(wallet);
        return updatedWallet;
    }
}
