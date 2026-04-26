package com.mycode.BlogApp.controller;

import com.mycode.BlogApp.dto.LoginRequestDTO;
import com.mycode.BlogApp.dto.LoginResponseDTO;
import com.mycode.BlogApp.dto.UserRequestDTO;
import com.mycode.BlogApp.dto.UserResponseDTO;
import com.mycode.BlogApp.security.JwtUtil;
import com.mycode.BlogApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    //to register user
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    //to login user
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        //validate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getEmail(),
                        loginRequestDTO.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            String token = jwtUtil.generateToken(loginRequestDTO.getEmail());

            LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder()
                    .username(loginRequestDTO.getEmail())
                    .token(token).build();

            return new ResponseEntity<>(loginResponseDTO, HttpStatus.CREATED);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

}
