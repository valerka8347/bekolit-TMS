package com.example.bekolittms.service;

import com.example.bekolittms.entity.RoleEntity;
import com.example.bekolittms.entity.UserEntity;
import com.example.bekolittms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashSet;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserEntity user) {
        HashSet<RoleEntity> roles = new HashSet<>();
        roles.add(RoleEntity.USER);
        user.setRoles(roles);
        userRepository.save(user);
        userRepository.deleteAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
