package com.example.bnrapp.services;

import com.example.bnrapp.dto.AuthRequestDto;
import com.example.bnrapp.dto.AuthResponseDto;
import com.example.bnrapp.entity.User;

import java.util.Arrays;
import java.util.List;

public class AuthServiceImpl implements AuthService {


    @Override
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null; // user not found, return null
    }

    private final List<User> users = Arrays.asList(
            new User("alexiaoaida@gmail.com", "pisica"));

    //TEST WITH LIST
    public AuthResponseDto checkUserCredentials(AuthRequestDto loginRequestDto) {
        for (User user : users) {
            if (user.getEmail().equals(loginRequestDto.getEmail()) &&
                    user.getPassword().equals(loginRequestDto.getPassword())) {
                AuthResponseDto responseDto = new AuthResponseDto();
                responseDto.setEmail(user.getEmail());
                return responseDto;
            }
        }
        return null;
    }


}
