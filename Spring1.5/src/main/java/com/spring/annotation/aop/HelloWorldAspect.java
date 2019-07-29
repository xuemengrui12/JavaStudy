package com.spring.annotation.aop;

import com.spring.annotation.aop.service.IIntroductionService;
import com.spring.annotation.aop.service.impl.IntroductiondService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class HelloWorldAspect {
    //定义一个切入点，名字为“beforePointcut”
    @Pointcut(value = "execution(* com.spring..*.sayBefore(java.lang.String)) && args(param)", argNames = "param")
    public void beforePointcut(String param) {
    }

    //使用value引用切入点
    @Before(value = "beforePointcut(param)", argNames = "param")
    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }

    /**
     * 后置返回通知
     * value：指定切入点表达式或命名切入点；
     * pointcut：同样是指定切入点表达式或命名切入点，如果指定了将覆盖value属性指定的，
     * pointcut具有高优先级；
     *
     * @param retVal
     */
    @AfterReturning(value = "execution(* com.spring..*.sayBefore(..))",
            pointcut = "execution(* com.spring..*.sayAfterReturning(..))",
            argNames = "retVal", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("===========after returning advice retVal:" + retVal);
    }

    /**
     * 后置异常通知
     *
     * @param exception
     */
    @AfterThrowing(value = "execution(* com.spring..*.sayAfterThrowing(..))",
            argNames = "exception", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("===========after throwing advice exception:" + exception);
    }

    @After(value = "execution(* com.spring..*.sayAfterFinally(..))")
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }

    @Around(value = "execution(* com.spring..*.sayAround(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===========around before advice");
        Object retVal = pjp.proceed(new Object[]{"replace"});
        System.out.println("===========around after advice");
        return retVal;
    }

    @DeclareParents(value = "com.spring..*.IHelloWorldService+",
            defaultImpl = IntroductiondService.class)
    private IIntroductionService introductionService;

    @Around(value = "this(com.spring.annotation.aop.service.IIntroductionService+)")
    public Object thisPointcut(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===========around sssss advice");
        Object retVal = pjp.proceed();
        System.out.println("===========around ssss advice");
        return retVal;
    }
}
