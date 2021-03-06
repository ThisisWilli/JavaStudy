package com.coding.leetcode.array.findmediansortedarrays4;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.array.findmediansortedarrays4
 * \* author: Willi Wei
 * \* date: 2020-07-15 10:35:41
 * \* description:
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * \
 */
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;

        for (int i = 0; i <= len / 2; i++){
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])){
                right = A[aStart++];
            }else {
                right = B[bStart++];
            }
        }

        if ((len & 1) != 0){
            return right;
        }else {
            return (left + right) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {/*2, 4, 6, 8*/};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}