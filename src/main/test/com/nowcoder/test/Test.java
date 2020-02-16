package com.nowcoder.test;


/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-01-13 13:23
 **/

public class Test {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("abc");
        swap(str);
        System.out.println(str);
    }
    public static void swap(StringBuffer str){
        str.setCharAt(0, str.charAt(1));
    }
}
