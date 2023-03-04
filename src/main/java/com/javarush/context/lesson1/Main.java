package com.javarush.context.lesson1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);

        UserDao userDao = ctx.getBean(UserDao.class);
        User user1 = userDao.findByFirstName("Ivan");
        User user2 = userDao.findByFirstName("Sergey");

        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(user1);

    }
}