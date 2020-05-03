package com.study.reflection;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-05-02 20:41
 **/

public class Test05 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Student> c = Student.class;
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        Student student = new Student();
        Method setName = c.getDeclaredMethod("setName", String.class);
        setName.invoke(student,"willi");
        System.out.println(student);
        // 获得注解的value值
        Table table = (Table)c.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field{
    String column();
    String type();
    int length();
}


@Table("db_student")
class Student{
    @Field(column = "db_id", type = "int", length = 10)
    private int id;
    @Field(column = "db_age", type = "int", length = 10)
    private int age;
    @Field(column = "db_name", type = "varchar", length = 10)
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
