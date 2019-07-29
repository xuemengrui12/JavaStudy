package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 切面
 */
@Aspect //1
@Component //2
public class LogAspect {
	
	@Pointcut("@annotation(com.spring.aop.Action)") //3
	public void annotationPointCut(){}


	/**
	 * 直接声明切入点或者先声明切入点然后调用
	 * @param joinPoint
	 */
//	  @After("annotationPointCut()") //4
	  @After("@annotation(com.spring.aop.Action)") //4
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class); 
	        System.out.println("注解式拦截 " + action.name()); //5
	    }
	  
	   @Before("execution(* com.spring.aop.DemoMethodService.*(..))") //6
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        System.out.println("方法规则式拦截,"+method.getName());

	    }
	   
	  
	
}
