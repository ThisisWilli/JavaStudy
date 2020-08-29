package com.company.meituan;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-29 15:51
 *
 * 小团深谙保密工作的重要性，因此在某些明文的传输中会使用一种加密策略，小团如果需要传输一个字符串S，
 * 则他会为这个字符串添加一个头部字符串和一个尾部字符串。
 * 1。头部字符串满足至少包含一个“MT”子序列，且以T结尾。
 * 2。尾部字符串需要满足至少包含一个“MT”子序列，且以M开头。例如AAAMT和MAAAT都是一个合法的头部字符串，而MTAAA就不是合法的头部字符，
 * 很显然这样的头尾字符串并不一定是唯一的，因此我们还有一个约束，就是S是满足头尾字符串合法的情况下的最长的字符串。
 * 很显然这样的加密策略是支持解码的，给出你一个加密后的字符串，请你找出中间被加密的字符串S。
 *
 *
 *
 * 输入描述
 * 输入第一行是一个正整数n，表示加密后的字符串总长度。(1<=n<=100000)
 * 输入第二行是一个长度为n的仅由大写字母组成的字符串T。
 * 输出描述
 * 输出仅包含一个字符串S。
 * 样例输入
 * 10
 * MMATSATMMT
 * 样例输出
 * SATM
 **/

public class Main1 {
//    public static String getResult(String str){
//        // 确认头部字符串开头
//        int startLoc = 0, endLoc = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'T'){
//                if (hasSubString(str.substring(0, i + 1))){
//                    startLoc = i + 1;
//                    break;
//                }
//            }
//        }
//
//        // 确认尾部字符串开头
//        for (int i = 0; i < str.length(); i++) {
//            if (i > startLoc && str.charAt(i) == 'M'){
//                if (hasSubString(str.substring(i))){
//                    endLoc = i;
//                    break;
//                }
//            }
//        }
//        return str.substring(startLoc, endLoc + 1);
//    }
//
//    public static boolean hasSubString(String str){
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'M'){
//                for (int j = i; j < str.length(); j++){
//                    if (str.charAt(j) == 'T'){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        System.out.println(getResult(sc.nextLine()));
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String s = sc.next();
        char[] dict = {'M', 'T'};
        int index = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            if (dict[index] == s.charAt(i)){
                index++;
            }
            if (index > 1){
                start = i + 1;
                break;
            }
        }
        index = 1;

        for (int i = len - 1; i >=0; i--){
            if (dict[index] == s.charAt(i)){
                index--;
            }
            if (index < 0){
                end = i;
                break;
            }
        }
        System.out.println(s.substring(start, end));
    }
}
