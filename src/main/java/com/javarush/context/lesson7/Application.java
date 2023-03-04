package com.javarush.context.lesson7;

import com.javarush.context.lesson7.config.DataConfig;
import com.javarush.context.lesson7.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Slf4j
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
    }
}
