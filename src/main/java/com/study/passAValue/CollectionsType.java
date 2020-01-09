package com.study.passAValue;

import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.study.passAValue
 * \* author: Willi Wei
 * \* date: 2020-01-08 19:41:26
 * \* description:
 * \
 */
public class CollectionsType {
    public static void main(String[] args) {
        List<Integer> lstNums = new ArrayList<Integer>();
        lstNums.add(1);
        System.out.println("Size of list before List modification = " + lstNums.size());
        modifyList(lstNums);
        System.out.println("Size of list after List modification = " + lstNums.size());
    }

    /**
     * 1.在创建任何集合时，在stack中便会创建一个指向heap中多个对象的引用，当调用该方法时，一个引用的拷贝被创建传递到了方法中，现在有两个
     * 引用指向了真正的对象数据，其中任何一个引用的数据改变会影响到另一个
     * 2.在方法中，当我们调用lstParam.add(2)时，一个Integer对象在heap中被创建，添加到现有的list对象，所以原始的list引用可以看到这次修改
     * 因为2个引用都指向了内存中的同一个对象
     *
     * 自定义对象在stack中存储着指向它的引用。当调用calling modifyStudent()，在stack中创建了这个引用的拷贝，传递到了方法中。
     * 所以任何对这个对象属性的修改会影响原始的对象引用
     * @param lstParam
     */
    private static void modifyList(List<Integer> lstParam) {
        lstParam.add(2);
    }
}