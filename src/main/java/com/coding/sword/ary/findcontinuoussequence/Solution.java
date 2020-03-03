package com.coding.sword.ary.findcontinuoussequence;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-03 09:13
 **/

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3){
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<>();
//        LinkedList<Integer> temp = new LinkedList<>();
        // 用两个指针，small为1，big为2，先相加，如果和小于sum，那么big往后移动一个，如果大了，那么small删除一个，也就是向后移动一次
        int small = 1, big = 2;
        int mid = (1 + sum) / 2;
        int curSum = small + big;

        temp.add(small);
        temp.add(big);
        while (small < mid){
            if (curSum == sum){
                result.add(new ArrayList<>(temp));
//                temp = new ArrayList<>();
            }
            while (curSum > sum && small < mid){
                // 如果和大于sum，那么temp中移除small元素
                curSum -= small;
                temp.remove(0);
                small++;

                if (curSum == sum){
                    result.add(new ArrayList<>(temp));
//                    temp = new ArrayList<>();
                }
            }
            big++;
            curSum += big;
            temp.add(big);
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().FindContinuousSequence(15).forEach((list)->{
         list.forEach((num)->{
             System.out.print(num + " ");
         });
            System.out.println();
        });
    }
}
