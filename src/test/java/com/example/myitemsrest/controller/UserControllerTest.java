package com.example.myitemsrest.controller;

import com.example.myitemsrest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


class UserControllerTest {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
//
//    @Test
//    public void getUserByIdTest() {
//        int id = 25;
//        userRepository.getById(id);
//        ()
//
//    }




    @Test
    void getUsers() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateUser() {
    }
}