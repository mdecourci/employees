package co.uk.netpod.application.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;

import java.lang.reflect.Method;

@Aspect
public class LogExecutionAdvice {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LogExecutionAdvice.class);

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("EXECUTION TIME");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LogExecutionTime myAnnotation = method.getAnnotation(LogExecutionTime.class);

        return joinPoint.proceed();
    }
}
