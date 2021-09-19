package com.vinylshop.VinyllShop.controller;

import com.vinylshop.VinyllShop.model.LoginRequest;
import com.vinylshop.VinyllShop.model.RegistrationRequest;
import com.vinylshop.VinyllShop.model.Vinyl;
import com.vinylshop.VinyllShop.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping(path = "/")
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;

    @PostMapping("registration")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
