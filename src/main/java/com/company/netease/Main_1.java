package com.company.netease;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-12 15:35
 * 给定一个字符串，请返回满足以下条件的最长字符串的长度 a b c x y z 在字符串中恰好出现了偶数次
 *
 * 输入
 * 字符串s， s长度 >= 1
 *
 * amabc
 * 3
 *
 **/

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        ArrayList<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('b');
        chars.add('c');
        chars.add('x');
        chars.add('y');
        chars.add('z');

        HashMap<Integer, Integer> map = new HashMap<>();
        int size = s.length();
        int state = 0;
        int maxSize = 0;
        map.putIfAbsent(0, -1);
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < chars.size(); k++) {
                if (chars.get(k) == s.charAt(i)){
                    state ^= (chars.size() - k - 1) * 2;
                    break;
                }
            }
            if (map.containsKey(state)){
                maxSize = Math.max(maxSize, i - map.get(state));
            }
            map.putIfAbsent(state, i);
        }
        System.out.println(maxSize);
    }
}
