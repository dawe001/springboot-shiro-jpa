package com.kfit.anno;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

/**
 * Created by davi on 2017/8/20.
 */
@Inherited
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface MyAnno {


    String value() default  "aaa";//默认的属性

}
