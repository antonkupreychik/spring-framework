package com.javarush.context.lesson9.controller;

import com.javarush.context.lesson5.command.UserFindCommand;
import com.javarush.context.lesson7.dto.CountryDTO;
import com.javarush.context.lesson7.dto.PageDTO;
import com.javarush.context.lesson9.filter.CountryFilter;
import com.javarush.context.lesson9.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryRepository countryRepository;


    @GetMapping
    public ResponseEntity<?> findAll(@ModelAttribute @Validated CountryFilter countryFilter,
                                     BindingResult bindingResult,
                                     Pageable pageable) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce((s1, s2) -> s1 + "|" + s2);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        var countries = countryRepository.findAllByNameRuContainingIgnoreCaseOrNameEnContainingIgnoreCase(countryFilter.getNameEn(), countryFilter.getNameRu(), pageable);
        return ResponseEntity.ok(new PageDTO<>(countries, pageable));
    }

}
