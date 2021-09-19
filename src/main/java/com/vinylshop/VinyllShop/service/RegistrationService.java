package com.vinylshop.VinyllShop.service;

import com.vinylshop.VinyllShop.exceptions.InvalidEmailException;
import com.vinylshop.VinyllShop.model.AppUser;
import com.vinylshop.VinyllShop.model.AppUserRole;
import com.vinylshop.VinyllShop.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public void register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail){
            throw new InvalidEmailException(request.getEmail());
        }

        appUserService.signUpUser(
                new AppUser(
                        request.getEmail(),
                        request.getPassword(),
                        request.getFirstName(),
                        request.getLastName(),
                        AppUserRole.USER
                )
        );
    }
}
