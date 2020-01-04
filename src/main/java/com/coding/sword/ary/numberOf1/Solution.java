package com.coding.sword.ary.numberOf1;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.ary.numberOf1
 * \* author: Willi Wei
 * \* date: 2020-01-04 13:21:32
 * \* description:输入一个整数，输出该数二进制表示1的个数，其中负数用补码表示
 *    answer:如果一个整数不为0，那么这个整数至少有1位是1.如果把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有0都会
 *           变成0，其余所有位将不受到影响
 * \
 */
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            //做与运算，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0，那么一个整数的二进制有多少个1，就可以进行多少次
            //这样的操作 1100&1011=1000消去了一个1，以此类推
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1(12));
    }
}