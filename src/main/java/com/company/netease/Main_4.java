package com.company.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-12 15:55
 *
 * 7 3 1 4   14
 * 6 5       -1
 * 10 20 2 29 49
 **/

public class Main_4 {
    static int result = 0;
    public static void main(String[] args) {
//        boolean[] nums = new boolean[1000000000];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i].trim());
            sum += nums[i];
        }

        Arrays.sort(nums);
        if (sum % 7 == 0){
            System.out.println(sum);
            return;
        }
        for (int i = 0; i < nums.length; i++){
            dfs(nums, i, sum - nums[i]);
        }
        if (result == 0){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    public static void dfs(int[] nums, int loc, int tempSum){
        if (tempSum % 7 == 0){
            result = tempSum;
            return;
        }
        for (int i = loc + 1; i < nums.length; i++) {
            dfs(nums, i, tempSum - nums[i]);
        }
    }
}
