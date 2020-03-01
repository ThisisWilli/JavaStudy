package com.coding.sword.array.getnumberofk;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-01 09:10
 **/

public class Solution {
    /**
     * 寻找有序数组中数字k出现的次数，主要还是根据数组下表之差来判断数字k出现的次数，看到有序数组，可以很好的利用二分查找来降低时间复杂度
     * @param array 1, 2, 3, 3, 3, 4, 5
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array.length <= 0){
            return 0;
        }
        int first = getFirstIndexOfK(array, k, 0, array.length - 1);
        int end = getLastIndexOfK(array, array.length, k,0, array.length - 1);
        if (first > -1 && end > -1){
            return end - first + 1;
        }else {
            return 0;
        }
    }

    private int getFirstIndexOfK(int[] array, int k, int startIndex, int endIndex){
        // 如果startIndex > endIndex，那么递归结束
        if (startIndex > endIndex){
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        // 如果array[mid] = k, 那么判断他前面一个数是否也等于k，如果等于，那么endIndex=mid-1，继续向前查找
        if (array[mid] == k){
            if (mid > 0 && array[mid - 1] != k || mid == 0){
                return mid;
            }else {
                endIndex = mid - 1;
            }
        }
        // 如果array[mid] > k, 那么endIndex = mid-1，继续向前查找
        else if (array[mid] > k){
            endIndex = mid - 1;
        }
        // 如果array[mid] < k，那么startIndex = mid + 1，向后寻找
        else {
            startIndex = mid + 1;
        }
        return getFirstIndexOfK(array, k, startIndex, endIndex);
    }

    private int getLastIndexOfK(int[] array, int length, int k, int startIndex, int endIndex){
        if (startIndex > endIndex){
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (array[mid] == k){
            if (mid < length - 1 && array[mid + 1] != k || mid == length - 1){
                return mid;
            }else {
                startIndex = mid + 1;
            }
        }else if (array[mid] < k){
            startIndex = mid + 1;
        }else {
            endIndex = mid - 1;
        }
        return getLastIndexOfK(array, length, k, startIndex, endIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().GetNumberOfK(new int[]{3, 2, 1}, 3));
    }
}
