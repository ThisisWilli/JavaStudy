package com.coding.sword2nd.stack.minstack30;

import java.util.Deque;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.stack.minstack30
 * \* author: Willi Wei
 * \* date: 2020-07-08 16:15:23
 * \* description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * \
 */
public class MinStack {
    /** initialize your data structure here. */

    Deque<Integer> stack;
    Deque<Integer> minStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (x < min){
            min = x;
        }

        stack.offerLast(x);
        minStack.offerLast(min);
    }

    public void pop() {
        stack.pollLast();
        minStack.pollLast();
        // 注意：最小元素在出栈的时候，也要实时更新最小值
        if (minStack.peekLast() != null){
            min = minStack.peekLast();
        }else {
            min = Integer.MAX_VALUE;
        }

    }

    public int top() {
        return stack.peekLast() != null ? stack.peekLast() : -1;
    }

    public int min() {
        return minStack.peekLast() != null ? minStack.peekLast() : -1;
    }
}