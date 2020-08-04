package com.problemsolve.collection;

import java.util.TreeMap;

/**
 * \* project: JavaStudy
 * \* package: com.problemsolve.collection
 * \* author: Willi Wei
 * \* date: 2020-08-02 21:04:30
 * \* description:
 * \
 */
public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
//        map.put("a", 1);
        map.put(null, 2);
        map.forEach((k, v)-> System.out.println(k + v));
    }
}