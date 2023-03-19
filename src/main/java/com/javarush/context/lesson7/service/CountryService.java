package com.javarush.context.lesson7.service;

import com.javarush.context.lesson7.command.CountryCommand;
import com.javarush.context.lesson7.dto.CountryDTO;
import com.javarush.context.lesson7.dto.PageDTO;
import org.springframework.data.domain.Pageable;

public interface CountryService {

    CountryDTO getCountryById(Long id);

    PageDTO<CountryDTO> getCountry(Pageable pageable);

    CountryDTO saveCountry(CountryCommand countryCommand);
}
