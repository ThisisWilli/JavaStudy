package com.coding.sword.search.numberof1between1andn;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-22 09:23
 **/

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}
