package com.coding.sword.linkedlist.reverseList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.linkedlist.reverseList
 * \* author: Willi Wei
 * \* date: 2020-01-07 13:53:03
 * \* description: 输入一个链表，反转链表之后，输出新链表的表头
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
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode p = head;
        ListNode dummy = new ListNode(0);
        ListNode result = new ListNode(0);
        dummy.next = head;
        while (p != null){
            // 保存result后半部分，避免丢失
            ListNode temp = result.next;
            result.next = p;
            dummy.next = p.next;
            p.next = temp;
            p = dummy.next;
        }
        return result.next;
    }
}