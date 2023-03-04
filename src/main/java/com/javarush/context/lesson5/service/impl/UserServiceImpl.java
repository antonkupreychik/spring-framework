package com.javarush.context.lesson5.service.impl;

import com.javarush.context.lesson5.dto.UserDTO;
import com.javarush.context.lesson5.mapper.UserMapper;
import com.javarush.context.lesson5.repository.UserRepository;
import com.javarush.context.lesson5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
// userServiceImpl
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO);

    }
}
