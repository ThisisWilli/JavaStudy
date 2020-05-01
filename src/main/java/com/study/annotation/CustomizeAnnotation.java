package com.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-05-01 21:49
 **/

public class CustomizeAnnotation {

    @MyAnnotation2(name = "willi")
    String name;
    // 注解可以显式赋值
    @MyAnnotation2(name = "willi")
    public void test(){
        System.out.println(name);
    }

    @MyAnnotation3(value = "willi")
    public void test2(){

    }

    public static void main(String[] args) {
        Class<CustomizeAnnotation> c = CustomizeAnnotation.class;
        // 获取所有字段
        for(Field f : c.getDeclaredFields()){
            // 判断这个字段是否有MyField注解
            if(f.isAnnotationPresent(MyAnnotation2.class)){
                MyAnnotation2 annotation = f.getAnnotation(MyAnnotation2.class);
                System.out.println(annotation.name());
            }
        }

    }
}
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    // 注解的参数：参数类型 + 参数名()
    String name();
    int age() default 1;
    // 默认值为-1表示不存在
    int id() default -1;
    String[] schools() default {"hdu"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    // 注解的参数：参数类型 + 参数名()
    String value();
}

