package com.coding.leetcode.stack.maxdepthaftersplit;

import java.util.ArrayList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-01 09:26
 **/

public class Solution {
    public int[] maxDepthAfterSpli(String seq) {
        int[] res = new int[seq.length()];
        int d = 0;
        char[] chars = seq.toCharArray();
        for (int i = 0; i < seq.toCharArray().length; i++) {
            if (chars[i] == '('){
                d += 1;
                res[i] = (d % 2);
            }
            if (chars[i] == ')'){
                res[i] = (d % 2);
                d -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().maxDepthAfterSpli("(()())");
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
