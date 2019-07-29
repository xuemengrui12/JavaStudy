package com.spring.annotation.aop.service;


import com.spring.annotation.aop.Model;
import com.spring.annotation.aop.Secure;

import java.util.*;

@Secure
public interface IPointcutService {
    
     boolean test();


     boolean test(Object obj);

     boolean test(Date date);
    
     Model test(Model model);

     void test(@Secure String str1, @Secure String str2);

     void test(@Secure Model model1, @Secure Model model2);
    

     void test(Map<Model, Model> map);

     void test(Map map, int i);

     void test(HashMap<Model, Model> map, String str);

     void test(Collection<Model> collection);

     void test(Set<TestMap> set);
    
     void test(Stack<Map> list);
    
     static class TestMap extends HashMap {}


}
