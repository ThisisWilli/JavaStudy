package com.study.comparatorInterface;

import java.util.Arrays;
import java.util.Comparator;

/**
 * \* project: JavaStudy
 * \* package: com.study.comparatorInterface
 * \* author: Willi Wei
 * \* date: 2019-12-26 14:29:58
 * \* description:
 * \
 */
public class CompareTest {
    public static void main(String[] args) {
        String [] strings = new String[]{"ash", "bilibili", "cindy", "duck"};
        LengthComparator comp = new LengthComparator();
        CharacterComparator comp2 = new CharacterComparator();
        Comparator<String> stringComp = (first, second) -> (second.length() - first.length());
        Arrays.sort(strings, comp);
        System.out.println("按照元素长度排序");
        System.out.println(Arrays.toString(strings));

        System.out.println("lambda写法按照长度倒序排序");
        Arrays.sort(strings, stringComp);
        System.out.println(Arrays.toString(strings));

        System.out.println("按照字典序倒序排序");
        System.out.println(Arrays.toString(strings));
    }
}