package com.study.passAValue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-16 15:49
 **/

public class PassString {
    public static void main(String[] args) {
        String string = "123";
        StringBuffer stringBuffer = new StringBuffer("123");
        System.out.println("修改之前 " + string);
        changeString(string);
        System.out.println("修改之后 " + string);
        System.out.println("=======================");

        System.out.println("修改之前 " + stringBuffer);
        changeStringBuffer(stringBuffer);
        System.out.println("修改之后 " + stringBuffer);
    }
    public static void changeString(String string){
        string += "456";
    }

    public static void changeStringBuffer(StringBuffer stringBuffer){
        stringBuffer.append("456");
    }
}
