package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Component
@Aspect
public class ProfileAspect {
	@Around("classProfiled() || methodProfiled()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		System.out.println(String.format("%s runs %d %s", methodName, (stop - start), "ns"));
		return result;
	}

	@Pointcut("@annotation(com.example.aop.Profile)")
	public void classProfiled() {
	}

	@Pointcut("within(@com.example.aop.Profile *)")
	public void methodProfiled() {
	}
}
