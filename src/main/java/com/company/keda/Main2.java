package com.company.keda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-31 14:15
 *
 * 用某种排序方法队关键字排序 25，84，21，47，15，27，68，35，20
 *
 * 输出描述
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 47 27 68 35 84
 * 15 20 21 25 35 27 47 68 84
 * 15 20 21 25 27 35 47 68 84
 **/

public class Main2 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
//        int start = 0, end = nums.length - 1;
        if (start < end){
            int mid = partition(nums, start, end);
            System.out.println(Arrays.toString(nums));;
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int idx = right;
        for (int i = right - 1; i >= left; i--){
            if (nums[i] > pivot){
                int temp = nums[i];
                nums[i] = nums[--idx];
                nums[idx] = temp;
            }
        }
        nums[right] = nums[idx];
        nums[idx] = pivot;
//        System.out.println(Arrays.toString(nums));
        return idx;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        System.out.println(len);
        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

//        int[] nums = new int[]{25, 84, 21, 47, 15, 27, 68, 35, 20};
        new Main2().sortArray(nums);
//        for (int re : res) {
//            System.out.print(re + " ");
//        }
    }
}
