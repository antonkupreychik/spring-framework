package com.javarush.context.lesson9.filter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CountryFilter {
    @NotNull
    String nameRu;
    @Size(min = 3, max = 20)
    String nameEn;
}
