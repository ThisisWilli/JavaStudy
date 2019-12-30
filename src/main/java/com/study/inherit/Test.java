package com.study.inherit;

/**
 * \* project: JavaStudy
 * \* package: com.study.inherit
 * \* author: Willi Wei
 * \* date: 2019-12-23 21:16:40
 * \* description:
 * \
 */
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {

    String empID = "0000";

    public Employee(String id) {
        super("123");
        empID = id;
    }
}
public class Test {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}