package com.ziphiro.websocketChat.service.impl;

import com.ziphiro.websocketChat.entity.User;
import com.ziphiro.websocketChat.repository.UserRepository;
import com.ziphiro.websocketChat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        if (repository.findAllByName(user.getName()).isPresent()){
            throw new RuntimeException("user with this username already exists");
        }
        return repository.save(user);
    }
}
