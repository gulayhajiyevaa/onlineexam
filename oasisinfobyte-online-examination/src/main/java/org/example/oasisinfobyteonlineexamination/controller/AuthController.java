package org.example.oasisinfobyteonlineexamination.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.dto.AuthRequest;
import org.example.oasisinfobyteonlineexamination.dto.AuthResponse;
import org.example.oasisinfobyteonlineexamination.service.AuthService;
import org.example.oasisinfobyteonlineexamination.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final SessionService sessionService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        authService.register(request);
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        sessionService.closeSession(session);
        return ResponseEntity.ok("Logged out successfully.");
    }
}
