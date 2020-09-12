package com.company.beike;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-07 15:10
 * 构造特定字符串，有两种方法
 * 1。添加任意一个字符
 * 2。复制黏贴之前添加的所有字符，这种方法只能使用一次
 * 最少多少步才能完成构造
 * input
 * 6
 * abcdef
 * output
 * 6
 *
 * 9
 * ababababc
 *
 *
 * 6
 *
 * ddababababc
 **/

public class Main2 {

    public static void getResult(String str){
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i + 1;
        }
        int maxLoc = 1;
        int start = 0, end = str.length() - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            String left = str.substring(0, mid + 1);
            String right = "";
            if (2 * mid + 2 < str.length()){
                right = str.substring(mid + 1, 2 * mid + 2);
            }
            if ((2 * mid + 2) < str.length() && left.equals(right)){
                maxLoc = mid;
                break;
            }
            end--;
        }

        if (maxLoc > 1){
            dp[maxLoc * 2 + 1] = maxLoc + 2;
            for (int i = maxLoc * 2 + 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + 1;
            }
        }else {
            for (int i = 1; i < dp.length; i++) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[dp.length - 1]);
    }

    public static void getResult2(String s){
        if (s.length() <= 2){
            System.out.println(s.length());
            return;
        }
        int index = 0;
        for (int i = 0, j = s.length() / 2; i < s.length() / 2 && j >= 0; j--){
            int low = i;
            int high = j;
            while (low < j){
                if (s.charAt(low) == s.charAt(high)){
                    low++;
                    high++;
                }else {
                    break;
                }
            }
            if (low == j){
                index = j - 1;
                break;
            }
        }
        System.out.println(s.length() - index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        getResult2(str);
    }
}
