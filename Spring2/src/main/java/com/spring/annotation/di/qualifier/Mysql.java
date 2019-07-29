package com.spring.annotation.di.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/** 表示使用Mysql相关 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Mysql {
}
