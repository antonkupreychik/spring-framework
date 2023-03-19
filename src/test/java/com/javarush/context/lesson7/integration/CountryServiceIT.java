package com.javarush.context.lesson7.integration;

import com.javarush.context.lesson7.command.CountryCommand;
import com.javarush.context.lesson7.integration.annotation.IT;
import com.javarush.context.lesson7.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
@RequiredArgsConstructor
class CountryServiceIT {

    private final CountryService countryService;

    @Test
    void shoud_save_country() {
        CountryCommand countryCommand = CountryCommand.builder()
                .id(301L)
                .nameEn("Ukraine")
                .nameRu("Украина")
                .nameEs("Ucrania")
                .build();

        var expected = countryService.saveCountry(countryCommand);
        assertNotNull(expected);
    }
}
