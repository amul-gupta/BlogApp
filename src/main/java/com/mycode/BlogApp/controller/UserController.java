package com.mycode.BlogApp.controller;


import com.mycode.BlogApp.dto.UserRequestDTO;
import com.mycode.BlogApp.dto.UserResponseDTO;
import com.mycode.BlogApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO)
    {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO)
    {
        UserResponseDTO userResponseDTO = userService.updateUser(id,userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.ACCEPTED);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        boolean b = userService.deleteUser(id);
        return new ResponseEntity<>("record deleted successfully", HttpStatus.OK);
    }


    //get single user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id)
    {
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }


    //get all users
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers()
    {
        List<UserResponseDTO> userResponseDTOList = userService.getAllUsers();
        return new ResponseEntity<>(userResponseDTOList, HttpStatus.OK);
    }


}
