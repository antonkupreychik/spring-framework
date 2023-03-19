package com.javarush.context.lesson7;

import com.javarush.context.lesson7.config.DataConfig;
import com.javarush.context.lesson7.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
        CountryService countryService = context.getBean(CountryService.class);
        System.out.println(countryService.getCountryById(120L));
    }
}
