package com.company.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-06 19:02
 *
 * 135682318 121
 * 23457  2
 * 14282123  12212
 * 14231728 1212
 * 3
 * 1724153    121
 *
 *
 * 135682318 121
 * 14231728  1212
 **/

public class Main1 {
    public static void getResult(ArrayList<String> strs, int thresh, String target){
        StringBuilder cmp = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) < thresh){
                cmp.append(target.charAt(i));
            }
        }

        String result = cmp.toString();
        for (int i = 0; i < strs.size(); i++) {
            String cur = strs.get(i);
            StringBuilder curString = new StringBuilder();
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) < thresh){
                    curString.append(cur.charAt(j));
                }
            }
            if (curString.toString().contains(result)){
                System.out.println(cur);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strs = new ArrayList<>();
        String temp = sc.nextLine();
        while (temp.length() > 1){
            strs.add(temp);
            temp = sc.nextLine();
        }
        String sthresh = temp;
        String target = sc.nextLine();
        int thresh = Integer.parseInt(sthresh) + '0';
        getResult(strs, thresh, target);
    }
}
