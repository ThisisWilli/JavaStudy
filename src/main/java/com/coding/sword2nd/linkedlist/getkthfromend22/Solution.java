package com.coding.sword2nd.linkedlist.getkthfromend22;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.linkedlist.getkthfromend22
 * \* author: Willi Wei
 * \* date: 2020-07-02 22:22:22
 * \* description:
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 * \
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (k != 0){
            fast = fast.next;
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next;
    }
}