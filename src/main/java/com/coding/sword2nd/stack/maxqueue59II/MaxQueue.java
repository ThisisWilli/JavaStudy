package com.coding.sword2nd.stack.maxqueue59II;

import java.util.LinkedList;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-13 16:06
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 **/

public class MaxQueue {
    LinkedList<Integer> queue;
    LinkedList<Integer> maxQueue;
    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()){
            return -1;
        }else {
            return maxQueue.peekFirst();
        }
    }

    /**
     * 在队尾加入元素
     * @param value
     */
    public void push_back(int value) {
        queue.addLast(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value){
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    /**
     * 在队头出一个元素
     * @return
     */
    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int result = queue.peekFirst();
        if (queue.peekFirst().equals(maxQueue.peekFirst())){
            queue.removeFirst();
            maxQueue.removeFirst();
        }else {
            queue.removeFirst();
        }
        return result;
    }
}
