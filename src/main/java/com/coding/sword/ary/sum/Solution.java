package com.coding.sword.ary.sum;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-05 10:10
 **/

public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        // || 如果前面的表达式为真，后面表达式的内容不再判断； &&如果前面表达式为假，后面的是的表达式不会执行
        boolean flag = (n == 1) || (sum += Sum_Solution(n-1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Sum_Solution(4));
    }
}
