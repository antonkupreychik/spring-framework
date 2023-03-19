package com.javarush.context.lesson7.mapper;

import com.javarush.context.lesson7.command.CountryCommand;
import com.javarush.context.lesson7.dto.CountryDTO;
import com.javarush.context.lesson7.model.Country;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-14T23:48:07+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDTO mapToDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        return countryDTO;
    }

    @Override
    public Country mapToEntity(CountryCommand countryCommand) {
        if ( countryCommand == null ) {
            return null;
        }

        Country.CountryBuilder country = Country.builder();

        country.id( countryCommand.getId() );
        country.nameRu( countryCommand.getNameRu() );
        country.nameEn( countryCommand.getNameEn() );
        country.nameEs( countryCommand.getNameEs() );

        return country.build();
    }
}
