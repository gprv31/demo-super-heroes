package com.demo.heroes.application.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Logger {

  @Around("execution(* *(..)) && @annotation(com.demo.heroes.application.log.LogExecuteTimeMethod)")
  public Object log(ProceedingJoinPoint point) throws Throwable
  {
    long start = System.currentTimeMillis();
    Object result = point.proceed();
    log.info("className={}, methodName={}, timeMs={},threadId={}",
      MethodSignature.class.cast(point.getSignature()).getDeclaringTypeName(),
      MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
      System.currentTimeMillis() - start,
      Thread.currentThread().getId());
    return result;
  }
}
