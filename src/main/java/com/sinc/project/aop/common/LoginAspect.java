package com.sinc.project.aop.common;

//import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("loginAspect")
@Aspect
public class LoginAspect {
	@Before("execution(public * com.sinc.project..*Impl.say*(..))")
	public void before(JoinPoint join) {
//		joinpoint로 진행상황 등 정보를 활용할수 있게 됨
		System.out.println("aspect >>>>>>>>>> before advice");
		
	}
	
	@AfterThrowing(pointcut = "execution(public * com.sinc.project..*Impl.say*(..))", throwing="e")
	public void throwing(JoinPoint point, Exception e) {
		System.out.println("throwing!!");
		e.printStackTrace();
	}
}
