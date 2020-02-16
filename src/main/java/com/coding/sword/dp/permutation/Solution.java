package com.coding.sword.dp.permutation;

import java.util.*;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-16 09:28
 **/

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列
 * 出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Solution{

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 1){
            return new ArrayList<>(Arrays.asList(str));
        }
        // 不为0，则从头开始对字符串进行递归交换
        ArrayList<String> result = new ArrayList<>();
        helper(str.toCharArray(), result, 0);
        Collections.sort(result);
        return result;
    }



    private void helper(char[] str, ArrayList<String> result, int loc){
        if (loc == str.length - 1){
            if (!result.contains(String.valueOf(str))){
                result.add(String.valueOf(str));
            }
        }
        for (int i = loc; i < str.length; i++){
            swap(str, loc, i);
            helper(str, result, loc + 1);
            swap(str, loc, i);
        }
    }

    /**
     * 交换字符串中i，j的位置
     * @param cs
     * @param i
     * @param j
     */
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> abc = new Solution().Permutation("aab");
        abc.forEach(line->{
            System.out.println(line);
        });

    }
}
