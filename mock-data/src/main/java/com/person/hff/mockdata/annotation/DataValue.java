package com.person.hff.mockdata.annotation;

import com.person.hff.mockdata.annotation.data.AbstractGenerator;
import com.person.hff.mockdata.annotation.data.DefaultGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataValue {
    String value() default "";
    
    String columnName();

    Class<? extends AbstractGenerator> generator() default DefaultGenerator.class;
}
