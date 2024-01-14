package mybank_be.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mybank_be.rest.entity.Wallet;
import mybank_be.rest.service.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<?> createWallet(@RequestBody Wallet wallet) {
        Wallet savedWallet = walletService.createWallet(wallet);
        return ResponseEntity.ok(savedWallet);
    }

    @GetMapping
    public ResponseEntity<?> getAllWallets() {
        List<Wallet> wallets = walletService.getAllWallets();
        return ResponseEntity.ok(wallets);
    }

}
