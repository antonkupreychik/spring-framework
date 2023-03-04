package com.javarush.context.lesson3;

import org.springframework.beans.factory.FactoryBean;

import java.awt.*;
import java.util.Random;

public class ColorFactory implements FactoryBean<Color> {

    private final Random random = new Random();

    @Override
    public Color getObject() throws Exception {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public Color createRandomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public Color createRedColor() {
        return new Color(255, 0, 0);
    }
}
