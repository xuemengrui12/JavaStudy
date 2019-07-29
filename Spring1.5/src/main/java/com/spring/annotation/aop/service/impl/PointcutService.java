package com.spring.annotation.aop.service.impl;


import com.spring.annotation.aop.Model;
import com.spring.annotation.aop.Secure;
import com.spring.annotation.aop.service.IPointcutService;

import java.util.*;

@Secure
public class PointcutService implements IPointcutService, java.io.Serializable {

    @Override
    @Deprecated
    @Secure
    public boolean test() throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        //支付业务实现
        return true;
    }

    @Secure
    @Override
    public boolean test(Object obj) {
        System.out.println("====" + obj);
        return false;
    }

    @Override
    public boolean test(Date date) {
        return false;
    }

    @Override
    public Model test(Model model) {
        return null;
    }

    @Override
    public void test(String str1, String str2) {
    }

    @Override
    public void test(Model model1, Model model2) {

    }

    @Override
    public void test(Map<Model, Model> map) {

    }

    @Override
    public void test(Map map, int i) {

    }

    @Override
    public void test(HashMap<Model, Model> map, String str) {

    }

    @Override
    public void test(Collection<Model> collection) {

    }

    @Override
    public void test(Set<TestMap> set) {

    }

    @Override
    public void test(Stack<Map> list) {

    }
}
