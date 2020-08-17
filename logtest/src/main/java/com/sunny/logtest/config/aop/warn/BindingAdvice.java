package com.sunny.logtest.config.aop.warn;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

// Validation Check 
@Component
@Aspect
public class BindingAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(BindingAdvice.class);
  
	@Around("execution(* com.sunny.logtest.controller..*Controller.*(..))")
   public Object bindingPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	   
	   
      Object[] args = proceedingJoinPoint.getArgs();

      String type = proceedingJoinPoint.getSignature().getDeclaringTypeName() + ":"; // IndexController가 찍힐 예정
      String methodName = proceedingJoinPoint.getSignature().getName() + "()";
      
      for (Object arg : args) {
         if (arg instanceof BindingResult) { // type 비교해서 같은 타입이면 넣음
            BindingResult bindingResult = (BindingResult) arg;
            if (bindingResult.hasErrors()) {
               Map<String, String> errorMap = new HashMap<>();
               for (FieldError error : bindingResult.getFieldErrors()) {
            	   log.info("info 확인");
            	   log.debug("debug 확인");
            	   log.error("error확인");
            	   log.warn(type + methodName + error.getDefaultMessage());
                  errorMap.put(error.getField(), error.getDefaultMessage());
               }
               return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
            }
         }
      }
      return proceedingJoinPoint.proceed();
   }
}