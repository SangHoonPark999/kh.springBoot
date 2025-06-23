package com.kh.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ServiceLoggerAdvice {

	//@After("execution(*com.kh.service.BoardDAOService*.*(..))") // <-조인 포인트
	public void startLog(JoinPoint jp) {
		log.info("startLog");
		log.info("startLog : " + jp.getSignature());
		if (jp.getArgs() != null) {
			log.info("startLog : " + Arrays.toString(jp.getArgs()));
		}
	}

	@Around("execution(* com.kh.service.MemberDAOService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		//insert(), select(), delete(), selectAll() serviceImpl 실행하는것
		//핵심관심이 실행되는 부분
		Object result = pjp.proceed();
		long endTime = System.currentTimeMillis();
		log.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
		return result;
	}
	
}
