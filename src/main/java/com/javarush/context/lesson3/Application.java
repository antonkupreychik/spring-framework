package com.javarush.context.lesson3;

import com.javarush.context.lesson3.di.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Config.class);
        ctx.refresh();

        HelloWorld mb1 = ctx.getBean(HelloWorld.class);
        System.out.println(mb1.hashCode());

        HelloWorld mb2 = ctx.getBean(HelloWorld.class);
        System.out.println(mb2.hashCode());
        ctx.close();

    }
}
