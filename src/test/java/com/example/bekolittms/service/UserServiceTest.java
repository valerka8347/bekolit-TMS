package com.example.bekolittms.service;

import com.example.bekolittms.entity.RoleEntity;
import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {
    @MockBean
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    private UserDetails userDetails;
    private UserEntity userEntity;

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    private final HashSet<RoleEntity> ROLE = new HashSet<>(Arrays.asList(RoleEntity.USER, RoleEntity.ADMIN));

    @BeforeEach
    void settingsUser(){
     userEntity =new UserEntity();
     userEntity.setUsername(USERNAME);
     userEntity.setPassword(PASSWORD);
     userEntity.setRoles(ROLE);

     userDetails = org.springframework.security.core.userdetails.User.builder()
             .username(USERNAME)
             .password(PASSWORD)
             .authorities(ROLE)
             .build();
    }

    @Test
    void save() {
        Mockito.when(userRepository.findByUsername(USERNAME)).thenReturn(userEntity);
        UserDetails actual = userService.loadUserByUsername(USERNAME);
        assertEquals(userDetails, actual);
    }
}