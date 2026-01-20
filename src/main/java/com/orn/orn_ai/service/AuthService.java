package com.orn.orn_ai.service;

import com.orn.orn_ai.dto.AuthResponse;
import com.orn.orn_ai.dto.LoginRequest;
import com.orn.orn_ai.dto.LoginResponse;
import com.orn.orn_ai.dto.SignupRequest;
import com.orn.orn_ai.entity.User;
import com.orn.orn_ai.exception.EmailAlreadyExistsException;
import com.orn.orn_ai.exception.InvalidCredentialsException;
import com.orn.orn_ai.repository.UserRepository;
import com.orn.orn_ai.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse signup(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email is already in use.");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : User.Role.USER);

        User savedUser = userRepository.save(user);

        return AuthResponse.builder()
                .message("User registered successfully!")
                .user(savedUser)
                .build();
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }

        String token = jwtUtil.generateToken(user);

        return LoginResponse.builder()
                .message("Login successful!")
                .token(token)
                .user(user)
                .build();
    }
}
