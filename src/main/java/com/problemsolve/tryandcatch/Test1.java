package com.problemsolve.tryandcatch;

/**
 * \* project: JavaStudy
 * \* package: com.problemsolve.whyequals.tryandcatch
 * \* author: Willi Wei
 * \* date: 2020-07-03 20:19:09
 * \* description:
 * \
 */
public class Test1 {
    public static void main(String[] args) {
//        System.out.println(new Test1().division(0));
//        System.out.println(new Test1().returnString());
        System.out.println(new Test1().returnBasicDataType());
    }

    public int division(int x){
        try {
            System.out.println("try block....");
            return 10 / x;
        } catch (Exception e) {
            System.out.println("exception occurred");
            e.printStackTrace();
            return -1;
        }
    }

    public int returnBasicDataType(){
        int x = 1;
        try {
            x = 2;
            return x;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            x = 3;
        }
        return x;
    }

    public String returnString(){
        String result = "1";
        try {
            result = "2";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            result = "3";
            return result;
        }

    }
}