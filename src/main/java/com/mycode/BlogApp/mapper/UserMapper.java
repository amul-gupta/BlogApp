package com.mycode.BlogApp.mapper;

import com.mycode.BlogApp.dto.UserRequestDTO;
import com.mycode.BlogApp.dto.UserResponseDTO;
import com.mycode.BlogApp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

     public  UserResponseDTO toDto(User user)
    {
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    public User toEntity(UserRequestDTO userRequestDTO)
    {
         return User.builder()
                 .username(userRequestDTO.getUsername())
                 .email(userRequestDTO.getEmail())
                 .password(userRequestDTO.getPassword())
                 .roles(userRequestDTO.getRoles())
                 .build();
    }

}
