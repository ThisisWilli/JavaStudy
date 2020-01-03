package com.coding.sword.stack.twoStack2Array;

import java.util.Stack;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.stack.twoStack2Array
 * \* author: Willi Wei
 * \* date: 2020-01-03 10:15:10
 * \* description:用两个栈来实现队列
 * \
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            int peekNum = stack1.pop();
            stack2.push(peekNum);
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()){
            int peekNum = stack2.pop();
            stack1.push(peekNum);
        }
        return result;
    }
}