package com.javarush.context.lesson9;

import org.postgresql.jdbc2.optional.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class TestApplicationRunner {

    @MockBean
    private ConnectionPool connectionPool;
}
