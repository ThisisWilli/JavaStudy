package com.coding.sword.stack.isPopOrder;

import java.util.Stack;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.stack.isPopOrder
 * \* author: Willi Wei
 * \* date: 2020-01-09 11:14:00
 * \* description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *                例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的
 *                弹出序列。（注意：这两个序列的长度是相等的）
 * \
 */
public class Solution {
    /**
     * 借助一个辅助栈，遍历入栈顺序，先将第一个元素入栈，然后判断栈顶元素是不是出栈顺序得第一个元素。不是则入栈一个入栈序列中的元素
     * 如果是，则将栈顶元素出栈，并将出栈元素的指针后移一位
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0){
            return false;
        }
        // 创建一个辅助栈
        Stack<Integer> stack = new Stack<>();
        // 定义出栈序列中的index
        int popIndex = 0;
        // 遍历入栈序列
        for (int i = 0;i < pushA.length; i++){
            // 先将一个元素入栈辅助栈中
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[popIndex]){
                // 栈顶元素出栈
                stack.pop();
                // 弹出序列向后一位
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}