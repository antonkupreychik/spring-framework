package com.javarush.context.lesson5.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAspect {

    // @within - проверяет наличиие аннотаици на уровне класса
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {
    }
/*

    // within - проверяет наличиие класса в указаном пакете
    @Pointcut("within(com.javarush.context.lesson5.service.impl)")
    public void isServiceLayer() {
    }
*/

    // this - обращение идет к прокси которое лежит в АОР
    // target - напрямую к исходному объекту
    @Pointcut("this(org.springframework.data.repository.Repository)")
    public void isRepositoryLayer() {
    }

    // @annotation - проверяет аннотацию на уровне метода
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void isGetMapping() {
    }

    // можно складывать поинктаы
    @Pointcut("isControllerLayer() || !@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void isGetMappingAndControllerLayer() {
    }

    //args - для работы с аргмументами. только один аргумент и он только строка
    // @Pointcut("args(java.lang.String, .. )") - любое кол-во аргументов после, но первая строка
    // @Pointcut("args(java.lang.String, * )") -  один параметр после строки
    @Pointcut("args(java.lang.String)")
    public void isOnlyOneStringArgs() {
    }

    //@args  - проверяет аннотацию у аргумента
    @Pointcut("isControllerLayer() && @args(com.javarush.context.lesson5.annotations.Command)")
    public void hasCommandAsParam() {
    }

    // bean - смотрит на название бина
    @Pointcut("bean(*ServiceImpl)")
    public void isServiceBean() {
    }

    //execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
    //
    //         modifiers-pattern? - модификатор достпупа(опицонально)?
    //         ret-type-pattern - тип возвращаемого значения
    //         declaring-type-pattern?name-pattern(param-pattern) - класс(опионально), в котором объявлен метод и его имя
    //         throws-pattern? - исключения, которые может бросить метод(опиционально)


    @Pointcut("execution(* com.javarush.context.lesson5.service.impl.*.*(..))")
    public void anyFindByIdMethod() {
    }

    @Order(2)
    @Before(value = "anyFindByIdMethod() && args(id) && target(service))", argNames = "joinPoint,id,service")
    public void addLogging(JoinPoint joinPoint,
                           Object id,
                           Object service) {
        System.out.println("BEFORE: Invoke find by id method for id '" + id + "' in " + service.getClass().getSimpleName());
    }

    @AfterReturning(value = "anyFindByIdMethod() && args(id) && target(service))", argNames = "joinPoint,id,service")
    public void addLoggingAfterReturning(JoinPoint joinPoint,
                                         Object id,
                                         Object service) {
        System.out.println("AFTER_RETURN: Return find by id method for id '" + id + "' in " + service.getClass().getSimpleName());
    }

    @AfterThrowing(value = "anyFindByIdMethod() && args(id) && target(service))", argNames = "joinPoint,id,service, ex", throwing = "ex")
    public void addLoggingThrowing(JoinPoint joinPoint,
                                   Object id,
                                   Object service,
                                   RuntimeException ex) {
        System.out.println("AFTER_THROWING: Return find by id method for id '" + id + "' in " + service.getClass().getSimpleName());
        System.out.println("MESSAGE: " + ex.getMessage());
    }

    @After(value = "anyFindByIdMethod() && args(id) && target(service))", argNames = "joinPoint,id,service")
    public void addLoggingAfterMethod(JoinPoint joinPoint,
                                      Object id,
                                      Object service) {
        System.out.println("AFTER: Invoke find by id method for id '" + id + "' in " + service.getClass().getSimpleName());
    }


}
