package com.javarush.context.lesson7.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryCommand {
    private Long id;
    private String nameRu;
    private String nameEn;
    private String nameEs;
}
