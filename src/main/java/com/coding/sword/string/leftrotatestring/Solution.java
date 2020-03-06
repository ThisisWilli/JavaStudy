package com.coding.sword.string.leftrotatestring;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-06 09:47
 **/


/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (n <= 0 || str.length() == 0){
            return str;
        }
        // 左移位数大于字符串长度时取余数
        if (n > str.length()){
            n = n % str.length();
        }
        StringBuffer sb = new StringBuffer(str);
        swap(sb, 0, n - 1);
        swap(sb, n, str.length() - 1);
        swap(sb,0, str.length() - 1);
        return sb.toString();

    }

    private void swap(StringBuffer stringBuffer, int start, int end){
        while (start < end){
            char temp = stringBuffer.charAt(start);
            stringBuffer.setCharAt(start, stringBuffer.charAt(end));
            stringBuffer.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LeftRotateString("abcXYZdef", 10));
    }
}
