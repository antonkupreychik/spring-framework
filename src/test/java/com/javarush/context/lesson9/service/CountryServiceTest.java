package com.javarush.context.lesson9.service;

import com.javarush.context.lesson9.TestApplicationRunner;
import com.javarush.context.lesson9.annotation.ITBoot;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.postgresql.jdbc2.optional.ConnectionPool;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;


@ITBoot
@RequiredArgsConstructor
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CountryServiceTest {

    private final ConnectionPool pool;

    @Test
    void test() {

    }

    @Test
    void test2() {

    }

    @Test
    void test3() {

    }
}