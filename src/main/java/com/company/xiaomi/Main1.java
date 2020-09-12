package com.company.xiaomi;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-08 18:21
 * 注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。
 * 检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。符合要求，
 * 返回 0；长度不符合返回 1；类型不符合要求返还 2。
 *
 * 可以一次输入多组密码，以空格符间隔，空格符不作为密码。
 *
 * 输入描述
 * 需要验证的密码，多个密码以空格符间隔，空格符不作为密码的一部分
 *
 * 输出描述
 * 每个密码的检查结果，每个结果需要换行输出
 *
 * 样例输入
 * 123 12345678 123abcABC!!!
 * 样例输出
 * 1
 * 2
 * 0
 **/

public class Main1 {
    public static int getResult(String s){
        if (s.length() < 8 || s.length() > 120){
            return 1;
        }
        boolean isDigit = false;
        boolean isFuhao = false;
        boolean isHighChar = false;
        boolean isLowChar = false;

        for (int i = 0; i < s.length(); i++) {
            if (!isDigit && s.charAt(i) >= '1' && s.charAt(i) <= '9'){
                isDigit = true;
            }else if (!isLowChar && s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                isLowChar = true;
            }else if (!isHighChar && s.charAt(i) >= 'A' && s.charAt(i) <= 'H'){
                isHighChar = true;
            }else {
                isFuhao = true;
            }

        }
        if (isDigit && isFuhao && isHighChar && isLowChar){
            return 0;
        }else {
            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (String s1 : s.split(" ")) {
            System.out.println(getResult(s1.trim()));
        }
    }
}
