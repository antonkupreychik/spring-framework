package com.javarush.context.lesson9.repository;

import com.javarush.context.lesson7.dto.CountryDTO;
import com.javarush.context.lesson9.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Page<CountryDTO> findAllByNameRuContainingIgnoreCaseOrNameEnContainingIgnoreCase(String nameRu, String nameEn, Pageable pageable);

}
