package com.coding.sword.array.printminnumber;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-23 09:09
 **/

import java.util.Arrays;
import java.util.Collections;

/**
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 解题思路，先将整形数组转化为字符串，再对字符串进行比较排序，将较小的字符串排在前面，要对字符串进行两两拼接比较
 * * 排序规则如下：
 *  * 若ab > ba 则 a > b，
 *  * 若ab < ba 则 a < b，
 *  * 若ab = ba 则 a = b；
 *  * 解释说明：
 *  * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
 */
public class Solution {
//    public String PrintMinNumber(int [] numbers) {
//        if (numbers.length == 0){
//            return null;
//        }
//        String[] strs = new String[numbers.length];
//        StringBuffer result = new StringBuffer();
//        for (int i = 0; i < numbers.length; i++){
//            strs[i] = String.valueOf(numbers[i]);
//        }
//        Arrays.sort(strs, (String o1, String o2)->{
//            String c1 = o1 + o2;
//            String c2 = o2 + o1;
//            return c1.compareTo(c2);
//        });
//        for (String str : strs){
//            result.append(str);
//        }
//        return result.toString();
//    }

    /**
     * 尝试采用全排列的方式进行解题
     * @param numbers
     * @return
     */
    private int result = Integer.MAX_VALUE;
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0){
            return "";
        }
        helper(numbers, 0, result);
        return String.valueOf(result);
    }

    private void helper(int[] numbers, int loc, int currentMin){
        // 交换到了最后一个数
        if (loc == numbers.length - 1){
            StringBuffer stringBuffer= new StringBuffer();
            for (int num : numbers){
//                System.out.print(num + " ");
                stringBuffer.append(num);
            }
//            System.out.println(stringBuffer);
            if (Integer.parseInt(stringBuffer.toString()) < currentMin){
                currentMin = Integer.parseInt(stringBuffer.toString());
                result = currentMin;
            }
//            System.out.println();
        }
        for (int i = loc; i < numbers.length; i++){
            swap(numbers, loc, i);
            helper(numbers, loc + 1, result);
            swap(numbers, loc, i);
        }
    }

    private void swap(int[] numbers, int a, int b){
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().PrintMinNumber(new int[]{3334,3,3333332}));
    }
}
