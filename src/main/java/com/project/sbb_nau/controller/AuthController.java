package com.project.sbb_nau.controller;

import com.project.sbb_nau.config.dto.RegistrationRequestDto;
import com.project.sbb_nau.config.jwt.JwtProvider;
import com.project.sbb_nau.entity.UserEntity;
import com.project.sbb_nau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:8081")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequestDto registrationRequestDto) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequestDto.getPassword());
        u.setLogin(registrationRequestDto.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token, userEntity.getLogin());
    }
}
