package com.problemsolve.whyequals;

import java.util.HashMap;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-20 13:49
 **/

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Person) {
            Person anotherStudent = (Person) obj;

            if (this.getName() == anotherStudent.getName()
                    || this.getAge() == anotherStudent.getAge())
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.age * 100;
    }

    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 3);
        Person zhangsan2 = new Person("zhangsan", 3);
        HashMap<Person, Integer> hashMap = new HashMap<>();
        hashMap.put(zhangsan, 1);
        hashMap.put(zhangsan2, 2);
        hashMap.forEach((k, v)->{
            System.out.println(k + " " +  v);
        });
    }
}
