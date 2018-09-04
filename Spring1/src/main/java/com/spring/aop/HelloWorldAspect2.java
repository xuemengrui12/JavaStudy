package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;


@Aspect
public class HelloWorldAspect2 {

//    @Pointcut(value = "execution(* com.spring..*.sayBefore(java.lang.String)) && args(param)", argNames = "param")
//    public void beforePointcut(String param) {
//    }
//
//    @Before(value = "beforePointcut(param)", argNames = "param")
//    public void beforeAdvice(String param) {
//        System.out.println("===========before advice param:" + param);
//    }

//    @AfterReturning(value = "execution(* com.spring..*.sayBefore(..))",
//            pointcut = "execution(* com.spring..*.sayAfterReturning(..))",
//            argNames = "retVal", returning = "retVal")
//    public void afterReturningAdvice(Object retVal) {
//        System.out.println("===========after returning advice retVal:" + retVal);
//    }

//    @AfterThrowing(value = "execution(* com.spring..*.sayAfterThrowing(..))",
//            argNames = "exception", throwing = "exception")
//    public void afterThrowingAdvice(Exception exception) {
//        System.out.println("===========after throwing advice exception:" + exception);
//    }

//    @After(value="execution(* com.spring..*.sayAfterFinally(..))")
//    public void afterFinallyAdvice() {
//        System.out.println("===========after finally advice");
//    }

//    @Around(value="execution(* com.spring..*.sayAround(..))")
//    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("===========around before advice");
//        Object retVal = pjp.proceed(new Object[] {"replace"});
//        System.out.println("===========around after advice");
//        return retVal;
//    }

//    @DeclareParents(value = "com.spring..*.IHelloWorldService+",
//            defaultImpl = com.spring.aop.service.impl.IntroductiondService.class)
//    private IIntroductionService introductionService;

//    @Around(value="this(com.spring.aop.service.IIntroductionService+)")
//    public Object thisPointcut(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("===========around sssss advice");
//        Object retVal = pjp.proceed();
//        System.out.println("===========around ssss advice");
//        return retVal;
//    }
}
