package com.coding.sword.string.ReplaceSpace;

import java.util.function.ToIntFunction;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.string.ReplaceSpace
 * \* author: Willi Wei
 * \* date: 2019-12-30 21:30:21
 * \* description:替换空格，首先应该避免创建新的字符串，应该尽可能在原先的字符串上进行修改
 *                1、从前向后进行遍历，计算出空格的个数
 *                2、从后先前遍历，移动每个元素
 * \
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        int indexOld = str.length() - 1;
        // 将空格替换成%20之后字符串的长度
        int newLength = indexOld + spaceNum * 2;
        str.setLength(str.length() + spaceNum * 2);
        // 字符串变长之后的下标
        int indexNew = str.length() - 1;
        while (indexOld >=0 && indexOld < indexNew){
            if (str.charAt(indexOld) == ' '){
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            }else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
            indexOld--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().replaceSpace(new StringBuffer("we are happy")));
    }
}