package ua.javaPro.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
    @Around("execution(* ua.javaPro.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    MethodSignature methodSignature =
            (MethodSignature) proceedingJoinPoint.getSignature();
    String methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);
        Object targetMethod = proceedingJoinPoint.proceed();
        System.out.println("End of " + methodName);
        return targetMethod;
    }
}
