package com.dev.works.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.dev.works.service.DevHandler;

@Aspect
@Component
public class DevControllerAdvice {
	
	@Autowired
	private ApplicationContext context;
	
	@AfterReturning(pointcut="execution(* com.dev.mock.integration.*.*(..))", returning="returnValue")
	void cut(JoinPoint jp, Object returnValue) throws Exception {
		
		System.out.println(jp.getSignature().getName());
		
		DevHandler handler = context.getBean(DevHandler.class);
		
		returnValue = handler.handle(returnValue);
	}
}
