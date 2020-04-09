package com.shark.example.aop.log;

import com.shark.example.type.LogType;
import com.shark.example.util.log.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class TimeLogAspect {

    @Pointcut("@annotation(TimeLog))")
    public void timeLog(){}

    @Around("timeLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String packageName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("packageName: " + packageName + ", methodName:" + methodName );
        try {
            long start = System.currentTimeMillis();
            Object object =  proceedingJoinPoint.proceed();
            long executeTime = System.currentTimeMillis() - start;
            LogUtil.log(LogType.TIME, Long.valueOf(-1), packageName, methodName, String.valueOf(executeTime));
            return object;
        } catch (Throwable e) {
            LogUtil.log(LogType.ERROR, Long.valueOf(-1), packageName, methodName, e.getMessage());
            throw e;
        }
    }
}
