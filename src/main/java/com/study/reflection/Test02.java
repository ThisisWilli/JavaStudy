package com.study.reflection;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-05-02 09:40
 **/

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Person> c1 = Person.class;

        Class<?> c2 = Class.forName("com.study.reflection.Person");

        Person person = new Person();
        Class<? extends Person> c3 = person.getClass();


        Class<Integer> c4 = Integer.TYPE;


    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
