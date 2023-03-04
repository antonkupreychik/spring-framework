package com.javarush.context.lesson3.di;

import com.javarush.context.lesson3.HelloWorld;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.javarush.context.lesson3.di")
public class Config {

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

}
