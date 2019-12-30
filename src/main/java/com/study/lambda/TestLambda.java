package com.study.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * \* project: JavaStudy
 * \* package: com.study.lambda
 * \* author: Willi Wei
 * \* date: 2019-12-18 21:13:23
 * \* description:
 * \
 */
public class TestLambda {

    /***
     * 利用lambda方法来遍历list
     * @param list
     */
    public static void lambdaOperatorList(List<String> list){
        System.out.println(list);
        System.out.println("利用lambda中的forEach来遍历list");
        list.forEach(word-> System.out.print(word + "..."));
        System.out.println();
        System.out.println("=================");
        System.out.println("将list变为Stream流，并通过Stream流过滤一些元素");
        list.stream().filter(s->s.contains("Java")).collect(Collectors.toList()).forEach(word-> System.out.println(word));
        System.out.println("============利用map===========");
        list.stream().map(word->{
            return word;
        }).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("=========利用flatmap============");
        // distinct会去除相同元素只保留一份
        list.stream().map(word->{
            System.out.println(word.split(" ").length);
            return word.split(" ");
        }).flatMap(Arrays::stream).collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
    }

    /***
     * 利用Lambda方法来对Map进行操作
     * @param map
     */
    public static void lambdaOperatorMap(Map<String, Integer> map){
        System.out.println("利用lambda中的forEach来遍历map");
        map.forEach((k, v)->{
            System.out.println(k + "," + v);
        });
//        map.entrySet().stream().filter((k, v) ->{
//            return
//        })
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>(){{
         put("zhangsan", 100);
         put("lisi", 90);
         put("wangwu", 60);
        }};
        List<String> list = new ArrayList<>(Arrays.asList("Hello python", "Hello java", "Hello spark", "Hello hadoop"));
        lambdaOperatorList(list);
        lambdaOperatorMap(map);
    }
}