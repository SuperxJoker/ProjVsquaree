package com.example.bnrapp.services;

import com.example.bnrapp.dto.AuthRequestDto;
import com.example.bnrapp.dto.AuthResponseDto;
import com.example.bnrapp.entity.User;

public interface AuthService {
    User getUserByEmail(String email);
    AuthResponseDto checkUserCredentials(AuthRequestDto loginRequestDto);
}
