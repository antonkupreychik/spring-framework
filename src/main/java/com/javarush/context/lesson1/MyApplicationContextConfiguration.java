package com.javarush.context.lesson1;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class MyApplicationContextConfiguration {

    @Bean
    public String string(){
        return "";
    }


    @Bean(name = "postgres", value = "postgres")
    public DataSource dataSource() {
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setServerNames(new String[]{"localhost"});
        source.setPortNumbers(new int[]{5432});
        source.setDatabaseName("postgres");
        source.setUser("postgres");
        source.setPassword("postgres");
        return source;
    }

    @Bean
    public UserDao userDao(@Qualifier(value = "postgres") DataSource some){
        return new UserDao(some);
    }
}