package com.coding.leetcode.array.majorityelement;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-13 09:02
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * [2,2,1,1,1,2,2]
 * [2,2,1,1,1,3,3]
 * 1、暴力法
 * 2、Hashtable
 * 3、
 */
public class Solution {

    public int majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((o1, o2) -> {
            return o1 - o2;
        });
        list.forEach(System.out::println);
        int result = list.get(0), count = 1;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) == result){
                count++;
            }else {
                count--;
                if (count == 0){
                    result = list.get(i);
                    count = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{-1,100,2,100,100,4,100}));
    }
}
