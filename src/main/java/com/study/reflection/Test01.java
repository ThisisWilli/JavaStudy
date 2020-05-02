package com.study.reflection;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-05-02 09:17
 **/

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取对象
        Class<?> c = Class.forName("com.study.reflection.User");
        Class<?> c1 = Class.forName("com.study.reflection.User");
        System.out.println(c.hashCode());
        System.out.println(c1.hashCode());
    }
}

class User{
    private int age;
    private String name;

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
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User() {
    }
}
