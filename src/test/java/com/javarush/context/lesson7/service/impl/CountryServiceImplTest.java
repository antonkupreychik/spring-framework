package com.javarush.context.lesson7.service.impl;

import com.javarush.context.lesson7.dto.CountryDTO;
import com.javarush.context.lesson7.dto.PageDTO;
import com.javarush.context.lesson7.mapper.CountryMapper;
import com.javarush.context.lesson7.model.Country;
import com.javarush.context.lesson7.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryServiceImplTest {

    @InjectMocks
    private CountryServiceImpl countryService;
    @Mock
    private CountryRepository countryRepository;
    @Spy
    private CountryMapper countryMapper;

    @Test
    void should_find_country_by_id() {
        when(countryRepository.findById(1L)).thenReturn(Optional.of(new Country()));
        when(countryMapper.mapToDTO(any(Country.class))).thenReturn(new CountryDTO());

        var actual = countryService.getCountryById(1L);
        assertNotNull(actual);

        verify(countryRepository, times(1)).findById(1L);
        verify(countryMapper, times(1)).mapToDTO(any(Country.class));
    }

    @Test
    void should_not_find_country_by_id() {
        when(countryRepository.findById(1L)).thenReturn(Optional.empty());

        var actual = countryService.getCountryById(1L);
        assertNull(actual);

        verify(countryRepository, times(1)).findById(1L);
        verify(countryMapper, times(0)).mapToDTO(any(Country.class));
    }

    @Test
    void should_return_first_page() {
        Pageable pageable = PageRequest.of(0, 10);
        when(countryRepository.findAll(pageable)).thenReturn(new PageImpl<>(new ArrayList<>()));

        var actual = countryService.getCountry(pageable);
        assertNotNull(actual);
        assertInstanceOf(PageDTO.class, actual);

        verify(countryRepository, times(1)).findAll(pageable);
    }


}