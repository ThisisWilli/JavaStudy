package com.company.beike;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-07 16:21
 **/

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            HashMap<Character, Character> map = new HashMap<>();
            map.put('S', 'J');
            map.put('J', 'B');
            map.put('B', 'S');
            int left = 0, right = 0;
            if (map.get(s1[0].charAt(0)) == s1[3].charAt(0)){
                left++;
            }else {
                left--;
            }
            if (map.get(s1[0].charAt(0)) == s1[2].charAt(0)){
                left++;
            }else {
                left--;
            }
            if (map.get(s1[1].charAt(0)) == s1[3].charAt(0)){
                right++;
            }else {
                right--;
            }
            if (map.get(s1[1].charAt(0)) == s1[2].charAt(0)){
                right++;
            }else {
                right--;
            }

            if (left == right){
                System.out.println("same");
            }else if(left > right){
                System.out.println("left");
            }else {
                System.out.println("right");
            }
        }
    }
}
