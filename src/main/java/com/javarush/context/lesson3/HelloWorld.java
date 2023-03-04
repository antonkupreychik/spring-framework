package com.javarush.context.lesson3;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component("helloWorld")
public class HelloWorld implements InitializingBean, DisposableBean {


    public void init() {
        System.out.println("1.1");
    }

    public void destroy2() {
        System.out.println("2.2");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("2");
    }

}
