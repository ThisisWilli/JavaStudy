package com.coding.sword.linkedlist.findKthToTail;

import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.linkedlist.findKthToTail
 * \* author: Willi Wei
 * \* date: 2020-01-06 15:19:51
 * \* description:输入一个链表，输出该链表中倒数第k个结点
 * \
 */

class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     *1->2->3->4->5,利用快慢指针解题
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }

        ListNode result = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        for (int i = 0; i < k; i++){
            pre = pre.next;
        }
        if (pre == null){
            return null;
        }
        while (pre.next != null){
            pre = pre.next;
            result = result.next;
        }
        return result;
    }
}