package com.javarush.context.lesson5;

import com.javarush.context.lesson5.config.Lesson5Config;
import com.javarush.context.lesson5.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Lesson5Config.class);
        UserService userService = context.getBean(UserService.class);
        userService.findById(1L).ifPresent(System.out::println);
    }
}
