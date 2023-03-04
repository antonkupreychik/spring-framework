package com.javarush.context.lesson5.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AopAround {

    @Pointcut("execution(public * com.javarush.context.lesson5.service.impl.UserServiceImpl.findById(*))")
    public void anyFindByIdMethod() {
    }
    @Order(1)
    @Around(value = "anyFindByIdMethod() && args(id) && target(service))", argNames = "proceedingJoinPoint,id,service")
    public Object addLoggingAround(ProceedingJoinPoint proceedingJoinPoint, Object id,
                                   Object service) throws Throwable {
        System.out.println("AROUND_BEFORE: - invoked findById method in class {}, with id {}" + service + " " + id);
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("AROUND_AFTER_RETURNING: - invoked findById method in class {}, result {}" + service + " " + result);
            return result;
        } catch (Throwable ex) {
            System.out.println("AROUND_AFTER_THROWING: - invoked findById method in class {}, exception {}: {}" + service + " " + ex.getClass() + " " + ex.getMessage());
            throw ex;
        } finally {
            System.out.println("AROUND_AFTER_FINALLY: - invoked findById method in class {}" + service);
        }
    }
}
