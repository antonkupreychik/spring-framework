package com.javarush.context.lesson9.integration.repository;

import com.javarush.context.lesson9.annotation.ITBoot;
import com.javarush.context.lesson9.model.Country;
import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ITBoot
@Rollback
@Transactional
@RequiredArgsConstructor
class CountryRepositoryTest {

    private final EntityManager entityManager;

    @Test
    void findAllByNameRuContainingIgnoreCaseOrNameEnContainingIgnoreCase() {
        var country = entityManager.find(Country.class, 10);
        assertNotNull(country);
        assertThat(country.getLocales()).hasSize(2);
    }

    @Test
    void should_create_country() {
        var country = Country.builder()
                .id(303L)
                .nameEs("nameEs")
                .nameRu("nameRu")
                .nameEn("nameEn")
                .locales(Map.of(
                        "ru", "описание",
                        "en", "description"
                ))
                .build();
        entityManager.persist(country);
    }

}