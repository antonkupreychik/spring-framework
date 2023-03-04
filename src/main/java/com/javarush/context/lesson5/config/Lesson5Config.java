package com.javarush.context.lesson5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@ComponentScan("com.javarush.context.lesson5")
@Configuration
public class Lesson5Config {

}
