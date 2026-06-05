package com.capgemini.lms.model.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dto.LoginRequest;
import com.capgemini.lms.dto.RegisterRequest;
import com.capgemini.lms.dto.AuthResponse;
import com.capgemini.lms.exception.BadRequestException;
import com.capgemini.lms.exception.ResourceNotFoundException;
import com.capgemini.lms.model.entity.Role;
import com.capgemini.lms.model.entity.User;
import com.capgemini.lms.model.repository.UserRepository;
import com.capgemini.lms.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    
    public String register(RegisterRequest request) {

        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new BadRequestException("Username cannot be empty");
        }

        if (request.getPassword() == null || request.getPassword().length() < 6) {
            throw new BadRequestException("Password must be at least 6 characters");
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new BadRequestException("Username already exists");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT)
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    
    public AuthResponse login(LoginRequest request) {

        if (request.getEmail() == null || request.getPassword() == null) {
            throw new BadRequestException("Username and password are required");
        }

        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new BadRequestException("Invalid username or password");
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new AuthResponse(token);
    }
}