package com.company.bilibili;

import java.util.HashSet;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-13 18:16
 *
 * 给出4个1-10的数字，进行加减乘除，得到24就算赢
 * 7 2 1 10
 * 7 * 2 + 1 * 10
 **/

public class Main1 {
    boolean ans = false;
    public boolean Game24Points (int[] arr) {
        // write code here
        // ;
        if (arr.length == 0){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(arr[0]);
        dfs(arr, set, arr[0]);
        return ans;
    }

    public void dfs(int[] nums, HashSet<Integer> set, int sum){
        if (set.size() == 4 && sum != 24){
            return;
        }
        if (sum == 24){
            ans = true;
            return;
        }
        for (int i = 1; i < nums.length; i++){
            if (set.add(nums[i])){
                dfs(nums, set, sum + nums[i]);
                dfs(nums, set, sum - nums[i]);
                dfs(nums, set, sum * nums[i]);
                dfs(nums, set, sum / nums[i]);
                set.remove(nums[i]);
            }
        }
    }
}
