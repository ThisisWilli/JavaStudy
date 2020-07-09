package com.company.shein;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-09 19:03
 **/

public class Solution {
    /**
     * 在输入数组中的查找所在元素的位置以及查找次数,返回格式String ："i,c"  (i为元素下表，c为查找次数)
     * @param arr int整型一维数组 数组
     * @param key int整型 待查找的元素
     * @return string字符串
     */

    int loc = 0;
    int count = 0;
    public String binSearch (int[] arr, int key) {
        // write code here
        int start = 0, end = arr.length - 1;

        int mid = (start + end) / 2;
        if (arr[mid] == key){
            loc = mid;
            count++;
        }
        if (arr[mid] > key){
            count++;
            helper(arr, key, start, mid);
//            count++;
        }else {
            count++;
            helper(arr, key, mid + 1, end);
//            count++;
        }
        return "" + loc + "," + count;
    }

    public void helper(int[] arr, int key,int start, int end){
        count++;
        int mid = (start + end) / 2;
        if (arr[mid] == key){
            loc = mid;
            return;
        }
        if (arr[mid] > key){
            helper(arr, key, start, mid);
        }else {
            helper(arr, key, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 9};
        System.out.println(new Solution().binSearch(nums, 6));
    }
}
