package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);
        if (optionalUser.isPresent()){
            var userDto = optionalUser.get();
            if (userDto.getPassword().equals(pw)){
                httpSession.setAttribute("USER", userDto);
            } else {
                throw new RuntimeException("Password not Match");
            }
        }else {
            throw new RuntimeException("User Not Found");
        }

    }

}
