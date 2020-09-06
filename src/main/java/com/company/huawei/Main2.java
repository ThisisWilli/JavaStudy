package com.company.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-06 19:33
 *
 * a~z, 0~9
 * 符号限制 , . ! ?
 **/

public class Main2 {

    public static boolean judge(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }

        if (s1.equals(s2)){
            return true;
        }
        int i = 0;
        while (i < s1.length()){
            if (s1.charAt(i) != s2.charAt(i)){
                if (Character.isLetterOrDigit(s1.charAt(i)) || Character.isLetterOrDigit(s2.charAt(i))
                        || s1.charAt(i) == '?' || s2.charAt(i) == '?'){
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static void getResult(List<String> l1, List<String> l2){
        int[][] dp = new int[l1.size() + 1][l2.size() + 1];
        for (int i = 1; i < l1.size(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i < l2.size(); i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= l1.size(); i++) {
            for (int j = 1; j <= l2.size(); j++) {
                dp[i][j] = dp[i - 1][j - 1];
                if (!judge(l1.get(i - 1), l2.get(j - 1))){
                    dp[i][j] += 2;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
            }
        }
        System.out.println("(" + dp[l1.size()][l2.size()] + "," + l2.size() + ")");
    }

    public static void transform(String s, List<String> list){
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                builder.append(c);
            }else if (c == ' '){
                if (builder.length() != 0)
                    list.add(builder.toString());
                builder = new StringBuilder();
            }else {
                if (builder.length() != 0)
                    list.add(builder.toString());
                list.add(String.valueOf(c));
                builder = new StringBuilder();
            }
            i++;
        }
        if (builder.length() != 0){
            list.add(builder.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String originString = sc.nextLine();
        String[] temp = originString.split(";");
        if (temp.length == 0){
            System.out.println("(0,0)");
            return;
        }
        if (temp.length == 1 && originString.charAt(0) != ';'){
            String s1 = temp[0];
            ArrayList<String> l1 = new ArrayList<>();
            transform(s1.toLowerCase(), l1);
            System.out.println("(" + l1.size()  + "," + '0' + ")");
            return;
        }
        String s1 = temp[0];
        ArrayList<String> l1 = new ArrayList<>();
        String s2 = temp[1];
        ArrayList<String> l2 = new ArrayList<>();
        transform(s1.toLowerCase(), l1);
        transform(s2.toLowerCase(), l2);
        if (l1.size() == 0 || l2.size() == 0){
            System.out.println("(" + Math.max(l1.size(), l2.size()) + "," + l2.size() + ")");
            return;
        }

        getResult(l1, l2);
    }
}
