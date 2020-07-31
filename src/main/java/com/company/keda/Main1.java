package com.company.keda;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-31 13:47
 *
 * 5个数字，表示1, 5, 10, 50, 100的纸币数量，第二行表示要支付的金额
 * 5 2 2 3 5
 * 55
 * 2
 **/

public class Main1 {
    int ans = Integer.MAX_VALUE;
    int target;
    public int fun1(int[] price, int[] nums, int target){
        this.target = target;
        if (nums == null || nums.length == 0){
            return -1;
        }
        recur(price, nums, 0, 0);
        if (ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

    public void recur (int[] price, int[] nums, int level, int sum){
        if (sum == target){
            ans = Math.min(ans, level);
        }else if (sum > target){
        }else {
            for (int i = 0; i < price.length; i++) {
                if (nums[i] > 0){
                    nums[i]--;
                    recur(price, nums, level + 1, sum + price[i]);
                    nums[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prices = new int[]{1, 5, 10, 50, 100};
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        System.out.println(new Main1().fun1(prices, nums, target));
    }
}
