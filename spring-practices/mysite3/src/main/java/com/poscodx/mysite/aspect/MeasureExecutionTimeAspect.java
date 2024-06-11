package com.poscodx.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasureExecutionTimeAspect {
	
	@Around("execution(* com.poscodx.mysite.repository..*(..))")
	public Object adviceAround(ProceedingJoinPoint joinpoint) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = joinpoint.proceed();
		
		sw.stop();
		long totalTime = sw.getTotalTimeMillis();
		
		String className = joinpoint.getTarget().getClass().getName();
		String methodName = joinpoint.getSignature().getName();
		String taskName = className + "." + methodName;
		
		System.out.println("[Execution Time]["+taskName+"]" + totalTime);
		
		return result;

		
	}
}
