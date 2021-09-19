package com.vinylshop.VinyllShop.service;

//import com.vinylshop.VinyllShop.model.ConfirmationToken;
//import com.vinylshop.VinyllShop.repo.ConfirmationTokenRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class ConfirmationTokenService {
//    private final ConfirmationTokenRepo confirmationTokenRepository;
//
//    public void saveConfirmationToken(ConfirmationToken token) {
//        confirmationTokenRepository.save(token);
//    }
//
//    public Optional<ConfirmationToken> getToken(String token) {
//        return confirmationTokenRepository.findByToken(token);
//    }
//
//    public int setConfirmedAt(String token) {
//        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
//    }
//}
