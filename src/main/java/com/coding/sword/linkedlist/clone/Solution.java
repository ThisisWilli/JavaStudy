package com.coding.sword.linkedlist.clone;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JavaStudy
 * @description:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点，
 *              返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author: Hoodie_Willi
 * @create: 2020-01-17 17:26
 **/

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        // 解法一
        // 使用hashmap存储下每个节点的random节点信息
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(pHead.label);
        nodeMap.put(pHead, newHead);
        // 每次都是创建一个新节点，有一个指针要指向原来的newHead
        RandomListNode record = newHead, p = pHead.next;
        while (p != null){
            newHead.next = new RandomListNode(p.label);
            // 将<A, A'>对应关系放入map
            nodeMap.put(p, newHead.next);
            p = p.next;
            newHead = newHead.next;
        }
        // 复制完之后，遍历新复制出来的链表，通过hashmap的映射关系，查找random节点的值
        newHead = record;
        while (pHead != null){
            // 先取出A的random C，再取出C对应的value C'
            if (pHead.random != null){
                newHead.random = nodeMap.get(pHead.random);
            }
            newHead = newHead.next;
            pHead = pHead.next;
        }
        return record;
    }
}
