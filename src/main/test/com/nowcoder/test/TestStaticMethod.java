package com.nowcoder.test;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-01-17 15:49
 **/

public class TestStaticMethod {
    public static void print(){
        Person person = new Person();
        person.printAge();
    }
    public static void main(String[] args) {
        print();
    }
}
