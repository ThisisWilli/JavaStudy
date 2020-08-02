package com.study.collectioniterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-02 13:40
 **/

public class TestListIterator {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        //其余代码都没有修改，就在list.add("3")之后添加这一行
//        list.add("4");
//        list.add("5");
//        for (Object o : list) {
//            if ("3".equals(o))
//                list.remove(o);
//        }
        for (Object o : list) {
            System.out.println(o);
        }

        list.forEach(a-> System.out.println(a));
        while (list.iterator().hasNext()) {
            System.out.println(list.iterator().next());
        }
    }

}
