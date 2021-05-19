package com.github.wanggaolei2019.mongodemo.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiJsonProperty {
    
    String key();  //key
    
    String example() default "";
    
    String type() default "string";  //支持string 和 int
    
    String description() default "";
    
}
