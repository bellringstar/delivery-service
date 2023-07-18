package com.example.cookie.controller;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class userApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest httpServletRequest,
            @CookieValue(required = false, name = "authorization-cookie")
            String authorizationCookie

    ){
        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUserDto = userRepository.findById(authorizationCookie);
        return optionalUserDto.get();


//        var cookies = httpServletRequest.getCookies();
//        if(cookies != null){
//            for(Cookie cookie : cookies){
//                log.info("ket : {}, value : {}", cookie.getName(), cookie.getValue());
//            }
//        }
//        return null;
    }
    @GetMapping("/me2")
    public UserDto me2(
        @RequestHeader(name="authorization", required = false)
        String authorizationHeader
    ){
        log.info("authorizationCookie : {}", authorizationHeader);

        var optionalUserDto = userRepository.findById(authorizationHeader);
        return optionalUserDto.get();
    }
}
