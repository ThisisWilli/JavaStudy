package com.study.comparatorInterface;

import java.util.Comparator;

/**
 * \* project: JavaStudy
 * \* package: com.study.comparatorInterface
 * \* author: Willi Wei
 * \* date: 2019-12-26 14:25:29
 * \* description:让数组不是按字典序进行排序，而是按照数组中元素的长度进行排序
 * \
 */
public class LengthComparator implements Comparator <String> {
    @Override
    public int compare(String o1, String o2) {
        /**
         * 将String数组按照数组长度进行升序排序
         */
        return o1.length() - o2.length();
    }
}