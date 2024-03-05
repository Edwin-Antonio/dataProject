package com.bankdata.securityAdmin.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    // Creamos la estructura de nuestro logger de que queremos mostrar en los
    // logs
    private Logger logger = Logger.getLogger(getClass().getName());

    // Creamos los pointcuts que deseemos hacer un tracking
    // Tracking para nuestro modelo de controlador
    @Pointcut("execution(* com.bankdata.securityAdmin.controller.*.*(..))")
    private void controllerLogger() {
    }

    // Tracking para nuestro modelo de controlador
    @Pointcut("execution(* com.bankdata.securityAdmin.service.*.*(..))")
    private void serviceLogger() {
    }

    // Tracking para nuestro modelo DAO
    @Pointcut("execution(* com.bankdata.securityAdmin.dao.*.*(..))")
    private void daoLogger() {
    }

    // Encapsulamos la implementación de nuesros tackers
    @Pointcut("controllerLogger() || serviceLogger() || daoLogger()")
    private void appFlowPointcuts() {
    }


    // Agregamos nuestro tracker @Before
    @Before("appFlowPointcuts()")
    private void before(JoinPoint joinPoint) {

        // Instanciamos nuestro Logg Message
        String pointMethod = joinPoint.getSignature().toShortString();
        logger.info("=====> on @Before trace --> calling method: " + pointMethod);

        // Mostramos los argumentos a nuestro metodo

        // Obtenemos nuestros argumentos
        Object[] args = joinPoint.getArgs();

        // Nos movemos a travez de nuestros argumentos
        for (Object tempArg : args) {
            logger.info("=====>> Argument(s): " + tempArg);
        }
    }

    // Agregamos nuestras sentencias para nuestro tracker @AfterReturning
    @AfterReturning(
        pointcut = "appFlowPointcuts()",
        returning = "theResult")
    public void afterRerutningMethod(JoinPoint joinPoint, Object theResult){

        // Instanciamos nuestro Logg Message
        String pointMethod = joinPoint.getSignature().toShortString();
        logger.info("=====> on @AfterReturning trace --> calling method: " + pointMethod);

        // Retornamos la información a mostras
        logger.info("=====>> results: "+ theResult);
    }
}
