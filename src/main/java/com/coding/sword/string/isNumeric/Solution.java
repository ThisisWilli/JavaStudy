package com.coding.sword.string.isNumeric;

/**
 * @program: JavaStudy
 * @description:请实现一个函数来判断字符串是否表示数值，包括整数和小数，例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
                但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author: Hoodie_Willi
 * @create: 2020-02-10 10:02
 **/

/**
 * 1、首先扫描正负号，然后再扫描正负号后面的整数数字
 * 2、判断是否遇到小数点 小数可以没有整数的部分
 * 实验用例：+100， -3.14159, -0.123
 */
public class Solution {
    private int loc = 0;
    public boolean isNumeric(char[] str) {
        if (str == null){
            return false;
        }
        boolean result = scanInteger(str);
        if (loc < str.length && str[loc] == '.'){
            loc++;
            result = scanUnsignedInteger(str) || result;
        }
        if (loc < str.length && (str[loc] == 'e' || str[loc] == 'E')){
            loc++;
            result = result && scanInteger(str);

        }
        return result && loc >= str.length;
    }

    // 判断是否为无符号整数
    private boolean scanUnsignedInteger(char[] str){
        int before = loc;
        while(loc < str.length && str[loc]>='0' && str[loc]<='9'){
            loc++;
        }
        return loc > before;
    }

    // 判断是否为整数
    private boolean scanInteger(char[] str){
        if (loc < str.length && (str[loc] == '+' || str[loc] == '-')){
            loc++;
        }
        return scanUnsignedInteger(str);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isNumeric("100".toCharArray()));
    }
}
