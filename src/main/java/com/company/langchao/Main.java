package com.company.langchao;

/**
 * \* project: JavaStudy
 * \* package: com.company.langchao
 * \* author: Willi Wei
 * \* date: 2020-07-15 21:01:15
 * \* description:将数组转换成有序数组的最少移动次数
 * \
 */
public class Main {
    public int count(int n, int[] nums){
        int maxCount = 1;
        int i = 0;

        while (i < n){
            int k = nums[i];
            int temp = 1;
            for (int j = i + 1; j < n; j++){
                if (k + 1 == nums[j]){
                    temp++;
                    k = nums[j];
                }
            }

            if (temp > maxCount){
                maxCount = temp;
            }
            i++;
        }
        return n - maxCount;
    }
}