package com.mycode.BlogApp.service.impl;

import com.mycode.BlogApp.dto.UserRequestDTO;
import com.mycode.BlogApp.dto.UserResponseDTO;
import com.mycode.BlogApp.entity.User;
import com.mycode.BlogApp.exception.ResourceNotFoundException;
import com.mycode.BlogApp.mapper.UserMapper;
import com.mycode.BlogApp.repository.UserRepository;
import com.mycode.BlogApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user id not found"));
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        return userMapper.toDto(user);
    }

    @Override
    public boolean deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user id not found"));
        userRepository.delete(user);
        return true;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(ob-> userMapper.toDto(ob)).toList();
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user id not found"));
        return userMapper.toDto(user);
    }
}
