package com.javarush.context.lesson7.service.impl;

import com.javarush.context.lesson7.command.CountryCommand;
import com.javarush.context.lesson7.dto.CountryDTO;
import com.javarush.context.lesson7.dto.PageDTO;
import com.javarush.context.lesson7.mapper.CountryMapper;
import com.javarush.context.lesson7.model.Country;
import com.javarush.context.lesson7.repository.CountryRepository;
import com.javarush.context.lesson7.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public CountryDTO getCountryById(Long id) {
        return countryRepository.findById(id)
                .map(countryMapper::mapToDTO)
                .orElse(null);
    }

    @Override
    public PageDTO<CountryDTO> getCountry(Pageable pageable) {
        return new PageDTO<>(countryRepository.findAll(pageable), pageable);
    }

    @Override
    public CountryDTO saveCountry(CountryCommand countryCommand) {
        var country = countryMapper.mapToEntity(countryCommand);
        return countryMapper.mapToDTO(countryRepository.save(country));
    }
}
