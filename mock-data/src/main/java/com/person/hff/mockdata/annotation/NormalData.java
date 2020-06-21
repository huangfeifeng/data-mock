package com.person.hff.mockdata.annotation;

import com.person.hff.mockdata.annotation.define.DefaultValueStrategy;
import com.person.hff.mockdata.annotation.define.ValueStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NormalData {

    String value();

    Class<? extends ValueStrategy> valueStrategy() default DefaultValueStrategy.class;
}
