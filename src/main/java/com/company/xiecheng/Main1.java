package com.company.xiecheng;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-08 19:29
 *
 * 敏感词替换
 *
 * you
 * i love you,oyu love me
 * jack
 *
 * i love jack,jack love me
 **/

public class Main1 {

    /**
     *
     * @param pattern
     * @param words
     * @param mingGan
     * @return
     */
    public static String getResult(String pattern, String words, String mingGan){
        LinkedList<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length()) {
            if (words.charAt(i) == ' '){
                result.add("" +words.charAt(i));
                i++;
            }else if ((words.charAt(i) >= 'a' && words.charAt(i) <= 'z')
                    || (words.charAt(i) >= 'A' && words.charAt(i) <= 'Z') ){
                while (i < words.length()){
                    if ((words.charAt(i) >= 'a' && words.charAt(i) <= 'z')
                            || (words.charAt(i) >= 'A' && words.charAt(i) <= 'Z')){
                        sb.append(words.charAt(i));
                        i++;
                    }else {
                        break;
                    }
                }
                result.add(judge(sb, new StringBuilder(mingGan)));
                i++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String s : result) {
            builder.append(s);
        }
        return new String(builder);
    }

    public static String judge(StringBuilder sb, StringBuilder target){
        if (sb.length() != target.length()){
            return sb.toString();
        }
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < target.length(); i++) {
            list.add(target.charAt(i));
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (list.contains(c)){
                int index = list.indexOf(c);
                list.remove(index);
            }
        }
        if (list.size() == 0){
            return sb.toString();
        }else {
            return target.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String words = sc.nextLine();
        String mingGan = sc.nextLine();
        getResult(pattern, words, mingGan);
    }
}
