package com.company.netease;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-12 16:48
 **/

public class Main_3 {
    static int ans;
    static int n;

    private static void dfs(int[][] matrix, int row, List<Integer> list, int k){
        if (k == 0){
            HashSet<Integer> set = new HashSet<>();
            ans = Math.max(ans, set.size());
        }else {
            int i = 0;
            while (i < n){
                if (matrix[row][i] == 1){
                    list.add(i);
                    dfs(matrix, i, list, k - 1);
                    list.remove(list.size() - 1);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        n = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[1]);
        int[][] matrix = new int[n][n];
        ss = sc.nextLine().split(" ");
        for (int i = 0; i < s.length(); i++) {
            int from = i + 1;
            int to = Integer.parseInt(ss[i]);
            matrix[from][to] = 1;
            matrix[to][from] = 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(matrix, 0, list, k);
        System.out.println(ans);
    }
}

