package com.coding.sword2nd.linkedlist.deletenode18;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.linkedlist.deletenode18
 * \* author: Willi Wei
 * \* date: 2020-07-03 11:21:08
 * \* description:
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * \
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head, slow = dummy;
        while (fast != null){
            if (fast.val == val){
                slow.next = fast.next;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return dummy.next;
    }
}