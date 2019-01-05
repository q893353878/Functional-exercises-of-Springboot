package com.st.aop;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited()
@Retention(RetentionPolicy.RUNTIME)
public @interface AopAnnotation {
    String value();
}
