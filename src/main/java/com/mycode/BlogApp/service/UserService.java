package com.mycode.BlogApp.service;

import com.mycode.BlogApp.dto.UserRequestDTO;
import com.mycode.BlogApp.dto.UserResponseDTO;
import com.mycode.BlogApp.entity.User;

import java.util.List;

public interface UserService {

    //create
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    //update
    UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO);

    //delete
    boolean deleteUser(Long userId);

    //get all users
    List<UserResponseDTO> getAllUsers();

    //get single user
    UserResponseDTO getUserById(Long userId);

}
