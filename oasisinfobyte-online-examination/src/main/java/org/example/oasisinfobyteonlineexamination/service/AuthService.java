package org.example.oasisinfobyteonlineexamination.service;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.dto.AuthRequest;
import org.example.oasisinfobyteonlineexamination.dto.AuthResponse;
import org.example.oasisinfobyteonlineexamination.entity.UserEntity;
import org.example.oasisinfobyteonlineexamination.enums.RoleEnum;
import org.example.oasisinfobyteonlineexamination.mapper.UserMapper;
import org.example.oasisinfobyteonlineexamination.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;

    public void register(AuthRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User with this email already exists");
        }
        UserEntity user = userMapper.toEntity(request);
        if (request.getEmail().endsWith("@admin.az")) {
            user.setRole(RoleEnum.ADMIN);
        } else {
            user.setRole(RoleEnum.USER);
        }
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepo.save(user);
    }

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(), request.getPassword())
                );
        UserEntity user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        return userMapper.toResponse(user);
    }
}
