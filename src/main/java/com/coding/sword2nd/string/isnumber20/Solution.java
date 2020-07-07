package com.coding.sword2nd.string.isnumber20;

import java.util.HashMap;
import java.util.Map;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.string.isnumber20
 * \* author: Willi Wei
 * \* date: 2020-07-07 14:51:19
 * \* description:
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值
 * ，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * \
 */
public class Solution {
    public boolean isNumber(String s) {
        HashMap[] states = {
                new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character, Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character, Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character, Integer>() {{ put(' ', 8); }}                                         // 8.

        };

        // p 开始的状态为0
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9'){
                t = 'd';
            }else if (c == '+' || c == '-'){
                t = 's';
            }else if (c == 'E' || c == 'e' || c == '.' || c == ' '){
                t = c;
            }else {
                t = '?';
            }

            if (!states[p].containsKey(t)){
                return false;
            }

            p = (int)states[p].get(t);
        }

        // 状态2，3，7，8是合格状态
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

}