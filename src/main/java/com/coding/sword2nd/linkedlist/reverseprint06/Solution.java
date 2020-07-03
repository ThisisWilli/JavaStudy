package com.coding.sword2nd.linkedlist.reverseprint06;

import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.linkedlist.reverseprint06
 * \* author: Willi Wei
 * \* date: 2020-07-03 11:29:54
 * \* description:
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        if (head == null){
            return new int[0];
        }

        while (head != null){
            list.addFirst(head.val);
            head = head.next;
        }

        int[] results = new int[list.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = list.pollFirst();
        }
        return results;
    }
}