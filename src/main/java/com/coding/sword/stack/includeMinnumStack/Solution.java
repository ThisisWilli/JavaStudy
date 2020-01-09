package com.coding.sword.stack.includeMinnumStack;

import java.util.Stack;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.stack.includeMinnumStack
 * \* author: Willi Wei
 * \* date: 2020-01-09 10:50:13
 * \* description:定义栈的数据结构，在该类型中实现一个能够得到栈中所含最小元素的min函数，时间复杂度为O(1)
 * \
 */
public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minNums = new Stack<Integer>();

    /**
     * 若入栈元素，比minNums栈顶元素更小，则入栈的同时也入minNums栈，否则不入栈
     * 注意：若与最小栈的栈顶元素相等，则也要入栈，因为出栈时要一一对应
     * @param node
     */
    public void push(int node) {
        stack.push(node);
        if (minNums.empty()){
            minNums.push(node);
        }else if (node <= minNums.peek()){
            minNums.push(node);
        }
    }

    /**
     * 注意：如果出栈元素同时包含在minNums中，minNums中的元素也要出栈
     */
    public void pop() {
        int num = stack.pop();
        if (num == minNums.peek()){
            minNums.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    /**
     * 思路用一个辅助栈保存依次入栈的最小数据
     * @return
     */
    public int min() {
        return minNums.peek();
    }
}