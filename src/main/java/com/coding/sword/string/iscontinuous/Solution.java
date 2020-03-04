package com.coding.sword.string.iscontinuous;

import java.util.Arrays;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-04 10:22
 **/

public class Solution {
    public boolean isContinuous(int [] numbers) {
        // 先将数组进行排序，然后判断其中0的个数
        if (numbers.length < 5){
            return false;
        }
        Arrays.sort(numbers);
        int zeroNumber = 0;
        int numOfInterval = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0){
                zeroNumber++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]){
                return false;
            }
            numOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        if (zeroNumber >= numOfInterval){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 2, 5, 4};
        Arrays.sort(numbers);
        for (int i : numbers) {
            System.out.println(i);
        }
    }
}
