package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.model.Circle;

@Aspect
public class LoggingAspect {

	@Before(value = "onAllCircleMethods()")
	public void loggingAdvice(JoinPoint jointPoint) {
		System.out.println(jointPoint.toString() + "  Target-"
				+ ((Circle) jointPoint.getTarget()).getName());
	}

	@Before(value = "allgetter()")
	public void loggingAdvice2(JoinPoint jointPoint) {
		System.out.println("Logging Advice message 2 invoked "
				+ jointPoint.getSignature() + " Source-"
				+ jointPoint.getStaticPart());
	}

	@AfterReturning(pointcut = "args(name)", returning = "returnName")
	public void setterInvokation(String name, String returnName) {
		System.out.println("Setter Method Invoked-'" + name
				+ "' Got in return-'" + returnName + "'");
	}

	@AfterThrowing(pointcut = "args(*)", throwing = "e")
	public void exceptionAdvice(Throwable e) {
		System.out.println("Got this exception " + e);
	}

	@Around(value = "@annotation(com.annotation.Loggable)")
	public Object aroundAdvice(ProceedingJoinPoint p) {
		System.out.println("Around Advice before target of kind -"
				+ p.getKind() + "\n");
		Object object = null;
		try {
			object = p.proceed();

		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("Around Advice after execute -" + object);
		return ((String) object) + " modified by advice";
	}

	@Pointcut("execution(public String *.get*())")
	public void allgetter() {
	}

	@Pointcut("within(com.model..*)")
	public void onAllCircleMethods() {
	}
	
	
}
