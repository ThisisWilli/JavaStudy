package com.coding.sword2nd.dp.translateNum47;


/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd
 * \* author: Willi Wei
 * \* date: 2020-07-10 15:50:55
 * \* description:
 * \
 */
public class Solution {


    public int translateNum(int num) {
        String s = String.valueOf(num);

        int n_1 = 1, n_2 = 1;
        for (int i = 2; i <= s.length(); i++){
            String substring = s.substring(i - 2, i);
            int c = substring.compareTo("10") >= 0 && substring.compareTo("25") <= 0 ? n_1 + n_2 : n_1;
            n_2 = n_1;
            n_1 = c;
        }
        return n_1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(123));
    }
}