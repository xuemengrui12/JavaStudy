package com.spring.aop;

import com.spring.aop.service.IPointcutService;
import org.aspectj.lang.JoinPoint;

public class ParameterAspect {
  
//    public void before(JoinPoint jp) {
//        System.out.println("==kind:" + jp.getKind());
//        System.out.println("==target:" + jp.getTarget());
//        System.out.println("==this:" + jp.getThis());
//        System.out.println("==args:" + jp.getArgs()[0]);
//        System.out.println("==signature:" + jp.getSignature());
//        System.out.println("==toString:" + jp.getStaticPart().toString());
//        System.out.println("==toShortString:" + jp.getStaticPart().toShortString());
//        System.out.println("==toLongString:" + jp.getStaticPart().toLongString());
//
//    }
    
//    public void before(JoinPoint.StaticPart jp1) {
//        System.out.println("===========JoinPoint.StaticPart==========");
//        System.out.println("==kind:" + jp1.getKind());
//        System.out.println("==signature:" + jp1.getSignature());
//        System.out.println("==toString:" + jp1.toString());
//        System.out.println("==toShortString:" + jp1.toShortString());
//        System.out.println("==toLongString:" + jp1.toLongString());
//
//    }

    public void before1(String param) {
        System.out.println("===param1:" + param);
    }

    public void before2(String param) {
        System.out.println("===param2:" + param);
    }

    public void before3(String param) {
        System.out.println("===param3:" + param);
    }
    public void before4(JoinPoint jp, String param) {
        System.out.println("===param4:" + param);
    }

    public void before5(JoinPoint jp, String param, IPointcutService pointcutService, Secure secure) {
        System.out.println("===param5:" + param);
        System.out.println("===target:" + pointcutService);
        System.out.println("===annotation:" + secure);
    }
    
    
//    private void pointcut1(String param){}
//
//    private void pointcut2(Secure secure){}
//
    public void before6(JoinPoint jp, String param, Secure secure) {
        System.out.println("===param6:" + param);
        System.out.println("===annotation:" + secure);
    }
    
}
