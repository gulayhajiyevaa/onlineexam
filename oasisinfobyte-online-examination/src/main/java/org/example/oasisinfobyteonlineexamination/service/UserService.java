package org.example.oasisinfobyteonlineexamination.service;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.dto.PasswordDto;
import org.example.oasisinfobyteonlineexamination.dto.UserDto;
import org.example.oasisinfobyteonlineexamination.entity.UserEntity;
import org.example.oasisinfobyteonlineexamination.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public void updateProfile(Long id, UserDto userDto) {
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        userRepo.save(user);
    }
    public void updatePassword(Long id, PasswordDto passwordDto) {
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
        if (!passwordDto.getOldPassword().equals(user.getPassword())) {
            throw new RuntimeException("Old password does not match.");
        }
        user.setPassword(passwordDto.getNewPassword());
        userRepo.save(user);
    }
}
