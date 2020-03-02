package com.coding.sword.array.findnumsappearonce;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-02 09:40
 **/

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 * 2, 4, 3, 6, 3, 2, 5, 5
 */
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length <= 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        // 首先将0与数组中的每个数组进行异或操作，因为0和任何数异或都是其本身，相同的数异或会在过程中被抵消，最后的结果就是出现一次的数相互异或的结果
        int bitResult = 0;
        for (int num : array) {
            bitResult ^= num;
        }
        // 找到bit位上位1的index，用来后面将数组分为两组
        int index = findFirst1(bitResult);
        // 异或后找到第一个为1的位数，将数组分为两组，分组的标准是位数为1的那位是否为1
        for (int num : array) {
            if (isBit1(num, index)){
                num1[0] ^= num;
            }else {
                num2[0] ^= num;
            }
        }
        //
    }

    private int findFirst1(int bitResult){
        int index = 0;
        while ((bitResult & 1) == 0  && index < 32){
            index++;
            bitResult = bitResult >> 1;
        }
        return index;
    }

    /**
     * 判断这个数的二进制index位上是否为1，如果为1，则分为一组，不为1则去另一组
     * @param target
     * @param index
     * @return
     */
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
