package com.netty.niobasic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.netty.niobasic
 * \* author: Willi Wei
 * \* date: 2020-09-24 15:00:31
 * \* description:
 * \
 */
public class Solution {

    public int getResult(int n){
        List<Integer> temp = new ArrayList<Integer>();
        HashSet<List<List<Integer>>> result = new HashSet<List<List<Integer>>>();
        for (int i = 1; i <= n; i++) {
            temp.add(i);
            dfs(n, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
        result.forEach(System.out::println);
        return result.size();
    }

    public void dfs(int n, int loc, List<Integer> temp, HashSet<List<List<Integer>>> result){
        if (temp.size() >= 2){
            addResult(temp, result);
            return;
        }
        if (loc >= n){
            return;
        }
        for (int i = loc; i <= n; i++){
            temp.add(i);
            dfs(n, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public void addResult(List<Integer> temp, HashSet<List<List<Integer>>> result){
        for (int i = 1; i < temp.size(); i++) {
            for (int j = 0; j <= i; j++){
                List<Integer> left = temp.subList(0, j);
                List<Integer> right = temp.subList(j, i);
                List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
                tempResult.add(new ArrayList<>(left));
                tempResult.add(new ArrayList<>(right));
                result.add(tempResult);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getResult(3));
    }
}