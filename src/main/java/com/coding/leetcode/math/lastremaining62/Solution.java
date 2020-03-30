package com.coding.leetcode.math.lastremaining62;

import java.util.ArrayList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-30 09:38
 **/

public class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        int index = 0;
        while (n > 1){
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(5, 3));
    }
}
