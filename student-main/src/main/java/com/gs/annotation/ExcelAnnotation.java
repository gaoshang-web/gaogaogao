package com.gs.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface ExcelAnnotation {
    //标题
    String title() default "";

    //sheet页名称
    String sheetName() default "";

    //文件夹路径
    String mkdir() default "";

    //字段
    String column() default "";
}
