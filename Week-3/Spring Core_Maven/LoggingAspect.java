package com.library;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* BookService.*(..))")
    public void logBefore() {
        System.out.println("[AOP] Before BookService method");
    }

    @After("execution(* BookService.*(..))")
    public void logAfter() {
        System.out.println("[AOP] After BookService method");
    }
}
