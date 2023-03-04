package com.javarush.context.lesson5.mapper;

import com.javarush.context.lesson1.User;
import com.javarush.context.lesson5.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toDTO(User user);
}
