package com.javarush.context.lesson7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class CountryDTO {
    private Long id;
    private String nameRu;

    @Override
    public String toString() {
        return "CountryDTO{" +
                "id=" + id +
                ", nameRu='" + nameRu + '\'' +
                '}';
    }
}
