package com.capgemini.lms.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.lms.dto.AuthResponse;
import com.capgemini.lms.dto.LoginRequest;
import com.capgemini.lms.dto.RegisterRequest;
import com.capgemini.lms.model.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest req) {
        String response = authService.register(req);
        return ResponseEntity.ok(response);
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

   
    @GetMapping("/me")
    public ResponseEntity<String> getCurrentUser(Principal principal) {
        return ResponseEntity.ok("Logged in as: " + principal.getName());
    }
}