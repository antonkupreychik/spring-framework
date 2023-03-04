package com.javarush.context.lesson7.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CountryDTO2 {
    Long getId();
    String getNameEn();
    String getNameRu();
    String getNameEs();

    @Value("#{target.nameEn + ' ' + target.nameRu}")
    String getTotal();
}
