package com.coding.leetcode.string.minimumlengthencoding820;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-28 09:17
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 1.将字符串反转
 * 2。反转之后按照字符串字典序进行排序
 * 3。判断这个字符串是否是下一个字符串的子串，如果是，则跳过，不是，则在结果上加单词长度和1
 **/

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0 || words == null){
            return 0;
        }
        int result = 0;

        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuffer(words[i]).reverse().toString();;
        }
        Arrays.sort(words);
        Arrays.asList(words).forEach(word->{
            System.out.print(word +" ");
        });
        System.out.println();
        // em, emit, lleb
        for (int i = 0; i < words.length; i++) {
            if (i + 1 < words.length && words[i + 1].startsWith(words[i])){
            }else {
                result += words[i].length() + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumLengthEncoding(new String[]{"hell", "time", "lime", "sometime", "shell", "me"}));
    }
}
