package com.javarush.context.lesson7.mapper;

import com.javarush.context.lesson7.command.CountryCommand;
import com.javarush.context.lesson7.dto.CountryDTO;
import com.javarush.context.lesson7.model.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CountryMapper {

    CountryDTO mapToDTO(Country country);

    Country mapToEntity(CountryCommand countryCommand);
}
