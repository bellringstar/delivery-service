package com.example.session.controller;

import com.example.session.model.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiContoller {

    @GetMapping("/me")
    public UserDto me(HttpSession httpSession){
        var userObject =  httpSession.getAttribute("USER");
        if (userObject != null){
            return (UserDto) userObject;
        }
        else {
            return null;
        }
    }

}
