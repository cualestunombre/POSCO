package aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect {
	
	@Before("execution(aoptest.vo.ProductVo aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}
	
	@After("execution(aoptest.vo.ProductVo aoptest.service.ProductService.find(String))")
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}
	
	
	@AfterReturning("execution(* *..*.ProductService.find(String))")
	public void adviceAfterReturning() {
		System.out.println("--- AfterReturning Advice ---");
	}
	
	@AfterThrowing(pointcut = "execution(* *..*.ProductService.find(String))", throwing="ex")
	public void adviceAfterThrowing(Throwable ex) {
		
		System.out.println("--- AfterThrowing Advice" + ex  + "---");
	}
	
	@Around("execution(* *..*.ProductService.find(String))")
	public Object adviceAround(ProceedingJoinPoint joinpoint) {
		System.out.println("--- Before Around ---");
		Object result = null;
		
		// parameter
		Object[] params = {"Computer"};
		
		try {
			result  = joinpoint.proceed(params);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	
		System.out.println("--- After Around ---");
		
		return result;
		
		
	}
	
}
	
	
