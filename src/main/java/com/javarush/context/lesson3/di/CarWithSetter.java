package com.javarush.context.lesson3.di;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
public class CarWithSetter {
    private Engine engine;

}
