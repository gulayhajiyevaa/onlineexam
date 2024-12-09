package org.example.oasisinfobyteonlineexamination.controller;

import lombok.RequiredArgsConstructor;
import org.example.oasisinfobyteonlineexamination.dto.PasswordDto;
import org.example.oasisinfobyteonlineexamination.dto.UserDto;
import org.example.oasisinfobyteonlineexamination.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userProfile")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}/update-profile")
    public void updateProfile(@PathVariable Long id,@RequestBody UserDto userDto) {
        userService.updateProfile(id, userDto);
    }

    @PutMapping("/{id}/update-password")
    public void updatePassword(@PathVariable Long id,@RequestBody PasswordDto passwordDto) {
        userService.updatePassword(id, passwordDto);
    }
}
