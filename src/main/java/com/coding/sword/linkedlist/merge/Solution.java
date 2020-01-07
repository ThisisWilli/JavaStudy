package com.coding.sword.linkedlist.merge;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.linkedlist.merge
 * \* author: Willi Wei
 * \* date: 2020-01-07 14:13:03
 * \* description:输入两个单调递增的链表，输出两个链表合成之后的链表，我们需要合成后的链表满足递增
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                head.next = p1;
                head = p1;
                p1 = p1.next;
                head.next = null;
            }else {
                head.next = p2;
                head = p2;
                p2 = p2.next;
                head.next = null;
            }
        }
        if (p1 != null){
            head.next = p1;
        }
        if (p2 != null){
            head.next = p2;
        }
        return result.next;
    }
}