package io.github.psauxit.pspenit.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(GroupValues.class)
public @interface Group {
    String name();

    String description() default "";
}