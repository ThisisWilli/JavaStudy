package com.study.comparatorInterface;

import java.util.Comparator;

/**
 * \* project: JavaStudy
 * \* package: com.study.comparatorInterface
 * \* author: Willi Wei
 * \* date: 2019-12-26 14:47:31
 * \* description:
 * \
 */
public class CharacterComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.charAt(0) - o1.charAt(0);
    }
}