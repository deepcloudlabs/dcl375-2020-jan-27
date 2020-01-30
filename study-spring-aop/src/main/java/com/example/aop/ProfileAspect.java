package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Component
@Aspect
public class ProfileAspect {
	@Around("@annotation(profile)")
	public Object profileMethod(ProceedingJoinPoint pjp, Profile profile) throws Throwable {
		return profile(pjp, profile);
	}

	@Around("@target(profile)")
	public Object profileAllClassMethods(ProceedingJoinPoint pjp, Profile profile) throws Throwable {
		return profile(pjp, profile);
	}

	public Object profile(ProceedingJoinPoint pjp, Profile profile) throws Throwable {
		String methodName = pjp.getSignature().getName();
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		System.out.println(String.format("%s runs %d %s %s", methodName, (stop - start), "ns", profile.value().name()));
		return result;
	}
}
