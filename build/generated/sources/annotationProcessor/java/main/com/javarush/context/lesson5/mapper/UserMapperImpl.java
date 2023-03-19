package com.javarush.context.lesson5.mapper;

import com.javarush.context.lesson1.User;
import com.javarush.context.lesson5.dto.UserDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T15:19:30+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = user.getId();
        name = user.getName();

        String email = null;

        UserDTO userDTO = new UserDTO( id, name, email );

        return userDTO;
    }
}
