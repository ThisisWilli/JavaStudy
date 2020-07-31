package com.study.annotation;

/**
 * \* project: JavaStudy
 * \* package: com.study.annotation
 * \* author: Willi Wei
 * \* date: 2020-07-31 20:34:23
 * \* description:
 * \
 */
public class GetClass {

    private String name;
    private Integer id;

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> name = Class.forName("com.study.annotation.GetClass");
        Class<GetClass> aClass = GetClass.class;
        Class<?>[] interfaces = aClass.getInterfaces();

    }
}