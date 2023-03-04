package com.javarush.context.lesson5.service;

import com.javarush.context.lesson5.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findById(Long id);
}
