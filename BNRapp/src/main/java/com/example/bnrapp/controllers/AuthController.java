package com.example.bnrapp.controllers;

import com.example.bnrapp.dto.AuthRequestDto;
import com.example.bnrapp.dto.AuthResponseDto;
import com.example.bnrapp.services.AuthService;
import com.example.bnrapp.services.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    //private final JwtService jwtTokenService;

    @PostMapping("/auth/login")
    private ResponseEntity<AuthResponseDto> loginUser(@RequestBody AuthRequestDto loginRequestDto) {
        AuthResponseDto loginResponseDto = authService.checkUserCredentials(loginRequestDto);

        if (loginResponseDto != null) {
            return ResponseEntity.ok(loginResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }



}