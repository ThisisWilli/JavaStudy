package com.company.xiaohongshu;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-12 10:10
 * 一个二叉树深度为k，节点取值为自然数,k<=5，找出不在树中的最小自然数，
 * 需要给出O(N)的算法。 bool exist(Tree tree, int n)
 *
 *
 *
 * 输入描述
 * [4,32,34,11,22,33,5,15,16,17,18]
 *
 * 输出描述
 * 1
 **/

public class Main1 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int findMin(int[] tree) {
        if (tree.length == 0){
            return 1;
        }
        int[] bucket = new int[tree.length + 1];
        int i = 0;
        while (i < tree.length) {
            if (tree[i] >= tree.length){
                i++;
                continue;
            }
            bucket[tree[i]]++;
            i++;
        }
        i = 1;
        while (i < bucket.length) {
            if (bucket[i] == 0){
                return i;
            }
            i++;
        }
        return tree.length + 1;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _tree_size = 0;
        _tree_size = Integer.parseInt(in.nextLine().trim());
        int[] _tree = new int[_tree_size];
        int _tree_item;
        for(int _tree_i = 0; _tree_i < _tree_size; _tree_i++) {
            _tree_item = Integer.parseInt(in.nextLine().trim());
            _tree[_tree_i] = _tree_item;
        }

        res = findMin(_tree);
        System.out.println(String.valueOf(res));

    }
}
