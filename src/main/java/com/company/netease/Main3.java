package com.company.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: netease
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-08 15:27
 *
 * n个题目，第i个题目的分数为Si，如果第i题回答正确，得到Si分，否则得0分，如果学生总分有数字5，那么这个学生得0分
 * 5
 * 5 15 5 15 5
 * 40
 **/


public class Main3{
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if(!containFive(sum)){
            System.out.println(sum);
            return;
        }
        Arrays.sort(arr);
        dfs(arr, arr.length - 1, 0);
        if(!flag)
            System.out.println(0);
    }

    public static void dfs(int[] arr, int index, int sum){
        if(index == -1){
            if(!containFive(sum)){
                System.out.println(sum);
                flag = true;
            }
            return;
        }
        if(flag)
            return;
        dfs(arr, index - 1, sum + arr[index]);
        if(flag)
            return;
        dfs(arr, index - 1, sum);
    }

    public static boolean containFive(int x){
        while (x > 0){
            if(x % 10 == 5)
                return true;
            x /= 10;
        }
        return false;
    }

}

