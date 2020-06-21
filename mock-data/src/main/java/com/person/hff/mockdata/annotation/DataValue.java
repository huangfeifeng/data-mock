package com.person.hff.mockdata.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataValue {
    String value() default "";
    
    String columnName();

    boolean loop() default false;

    String format() default "";

    String delimit() default "";

}
