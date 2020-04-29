package com.coding.leetcode.array.findinmountainarray1095;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-29 09:03
 *
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 *
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 示例 2：
 *
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 **/

interface MountainArray{
    int get(int index);
    int length();
}
public class Solution {
    /**
     * 1、先寻找数组中的山峰元素，如果这个数小于target，那么直接返回-1，前面条件成立，说明mount > target
     * 2、比较第一个元素与target元素，如果这个数小于target，则说明递增区间内可能存在target
     * 3、比较最后一个元素于target，如果这个数小于target，则说明target可能在递减区间内，在这个区间内进行二分查找
     * 4、如果两个区间内查找都没有找到，则返回-1
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        int mid = (left + right) / 2;
        int len = right + 1;
        while (left <= right){
            if (mountainArr.get(mid - 1) < mountainArr.get(mid)){
                if (mountainArr.get(mid + 1) > mountainArr.get(mid)){
                    left = mid + 1;
                }else {
                    break;
                }
            }else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
            if (mid == 0 || mid == len - 1){
                mid = mid == 0 ? 1 : len - 2;
                break;
            }
        }
        if (mountainArr.get(mid) < target){
            return -1;
        }

        if(mountainArr.get(0) <= target){
            // 左半部分递增区间内，l 指针指向0， r 指针指向峰值
            int l = 0;
            int r = mid;
            int m = l + (r - l) / 2;
            while(l <= r){
                // 递增区间内，若 中间值 小于 目标值，则往右半部分查找 目标值
                if(mountainArr.get(m) < target){
                    l = m + 1;
                    // 递增区间内，若 中间值 大于 目标值，则往左半部分查找 目标值
                }else if(mountainArr.get(m) > target){
                    r = m - 1;
                }else{
                    // 中间值 等于 目标值，直接返回
                    return m;
                }
                m = l + (r - l) / 2;
            }
        }
        // 最后一个元素不大于 target 时，在峰值之后的递减区间内寻找 target 。 否则说明递减区间不存在target
        if(mountainArr.get(len - 1) <= target){
            // 右半部分递减区间内， l 指针指向峰值， r 指针指向最后一个元素
            int l = mid;
            int r = len - 1;
            int m = l + (r - l) / 2;
            while(l <= r){
                // 递减区间内，若 中间值 小于 目标值，则往左半部分查找 目标值
                if(mountainArr.get(m) < target){
                    r = m - 1;
                    // 递减区间内，若 中间值 大于 目标值，则往右半部分查找 目标值
                }else if(mountainArr.get(m) > target){
                    l = m + 1;
                }else{
                    // 中间值 等于 目标值，直接返回
                    return m;
                }
                m = l + (r - l) / 2;
            }
        }
        // 若存在target，则在上面两个判断已经return，走到这一步说明数组不存在 target
        return -1;
    }
}
