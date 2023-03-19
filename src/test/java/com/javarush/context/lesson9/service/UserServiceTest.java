package com.javarush.context.lesson9.service;

import com.javarush.context.lesson7.integration.annotation.IT;
import com.javarush.context.lesson9.annotation.ITBoot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@ITBoot
class UserServiceTest {

    @Test
    void test() {
        System.out.println("dfdf");
    }
}