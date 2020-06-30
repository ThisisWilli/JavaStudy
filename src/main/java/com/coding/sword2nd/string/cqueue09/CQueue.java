package com.coding.sword2nd.string.cqueue09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.string.cqueue09
 * \* author: Willi Wei
 * \* date: 2020-06-30 14:49:11
 * \* description:
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * \
 */
public class CQueue {
    Deque<Integer> stack;
    Deque<Integer> temp;

    public CQueue() {
        stack = new LinkedList<>();
        temp = new LinkedList<>();
    }

    /**
     * 在尾部插入整数
     * 直接在stack尾部插入元素
     * @param value
     */
    public void appendTail(int value) {
        stack.addLast(value);
    }

    /**
     * 在头部删除整数，如果没有元素，则返回-1
     * 将stack元素插入辅助栈，再将头部元素删除，之后再放回stack
     * @return
     */
    public int deleteHead() {
        if (temp.isEmpty()){
            while (!stack.isEmpty()){
                temp.addLast(stack.pollLast());
            }
        }
        if (temp.isEmpty()){
            return -1;
        }else {
            return temp.pollLast();
        }
    }
}