package com.example.myitemsrest.controller;


import com.example.myitemsrest.dto.SaveUserRequest;
import com.example.myitemsrest.dto.UserResponseDto;
import com.example.myitemsrest.entity.Role;
import com.example.myitemsrest.entity.User;
import com.example.myitemsrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/users/{id}")
    public UserResponseDto getUserById(@PathVariable("id") int id) {
        return modelMapper.map(userRepository.getById(id), UserResponseDto.class);
    }

    @GetMapping("/users/")
    public List<UserResponseDto> getUsers() {
        List<UserResponseDto> result = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            result.add(modelMapper.map(user, UserResponseDto.class));
        }
        return result;
    }

    @PostMapping("/users/")
    public UserResponseDto saveUser(@RequestBody SaveUserRequest saveUserRequest) {
        User user = modelMapper.map(saveUserRequest, User.class);
        user.setRole(Role.USER);
        userRepository.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteById(@PathVariable ("id") int id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return  ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@RequestBody SaveUserRequest saveUserRequest,
                                      @PathVariable("id") int id) {
        User byId = userRepository.getById(id);
        if (saveUserRequest.getEmail() !=null) {
            byId.setEmail(saveUserRequest.getEmail());
        }
        if (saveUserRequest.getName() !=null) {
            byId.setName(saveUserRequest.getName());
        }
        if (saveUserRequest.getSurname() !=null) {
            byId.setName(saveUserRequest.getSurname());
        }
        if (saveUserRequest.getPassword() !=null) {
            byId.setName(saveUserRequest.getPassword());
        }
        if (saveUserRequest.getPhone() !=null) {
            byId.setName(saveUserRequest.getPhone());
        }
        userRepository.save(byId);
        return modelMapper.map(byId, UserResponseDto.class);
    }

}