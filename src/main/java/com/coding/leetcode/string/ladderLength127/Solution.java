package com.coding.leetcode.string.ladderLength127;

import java.util.*;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-13 09:46
 **/

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null){
            return 0;
        }
        // 如果wordList中不包含endWord，那么不用找了
        if (!wordList.contains(endWord)){
            return 0;
        }
        // 默认都没有访问过
        boolean[] visited = new boolean[wordList.size()];
        if (wordList.indexOf(beginWord) != -1){
            visited[wordList.indexOf(beginWord)] = true;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int count = 0;
        while (queue.size() > 0){
            int size = queue.size();
            count++;
            while (size-- > 0){
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); i++){
                    if (visited[i]){
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!isTwoCharDifferent(s, start)){
                        continue;
                    }
                    if (s.equals(endWord)){
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    private boolean isTwoCharDifferent(String s1, String s2){
        int count = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}
