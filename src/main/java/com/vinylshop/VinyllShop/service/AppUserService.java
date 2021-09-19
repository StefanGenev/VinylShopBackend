package com.vinylshop.VinyllShop.service;

import com.vinylshop.VinyllShop.model.AppUser;
import com.vinylshop.VinyllShop.repo.AppUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND = "User with email: %s not found";
    private final AppUserRepo appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final static int CONFIRMATION_TOKEN_EXPIRATION_PERIOD_IN_MINUTES = 30;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow( () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)) );
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists)
            throw new IllegalStateException("User with this email already exists");

        // Password encryption
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        // Save user
        appUserRepository.save(appUser);

        return "User registered";
    }

}
