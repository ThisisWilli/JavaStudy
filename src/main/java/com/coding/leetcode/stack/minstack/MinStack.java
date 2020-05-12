package com.coding.leetcode.stack.minstack;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.util.Stack;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.stack.minstack
 * \* author: Willi Wei
 * \* date: 2020-05-12 09:36:27
 * \* description:
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * \
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            if (x > minStack.peek()){
                x = minStack.peek();
            }
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}