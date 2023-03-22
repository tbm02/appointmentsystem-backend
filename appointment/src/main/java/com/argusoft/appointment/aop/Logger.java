package com.argusoft.appointment.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.argusoft.appointment.utils.logutils.ColorScheme;;

@Aspect
@Component
public class Logger {
    @Before("@annotation(com.argusoft.appointment.utils.customannotations.LogThis)")
    public void logMessage(JoinPoint joinPoint){
        System.out.println(ColorScheme.ANSI_YELLOW+joinPoint.getSignature()+":  args are as follows");
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
           System.out.println("Arg: " + signatureArg);
        }
    }
}
