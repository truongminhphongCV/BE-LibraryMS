package com.example.Library.service;

import com.example.Library.Entity.Role;
import com.example.Library.Entity.User;
import com.example.Library.dto.request.AuthenticationRequest;
import com.example.Library.dto.request.RegisterRequest;
import com.example.Library.dto.respone.AuthenticationResponse;
import com.example.Library.dto.respone.ResponeMessage;
import com.example.Library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public ResponeMessage register(RegisterRequest request) {
        if (repository.existsByEmail(request.getEmail())){
            return ResponeMessage.builder()
                    .message("The email existed! Please try again!")
                    .build();
        }
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();
        repository.save(user);
        return ResponeMessage.builder()
                .message("Register successful!")
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .fullName(user.getFirstname() + " " + user.getLastname())
                .role(user.getAuthorities().toString())
                .build();
    }
}
