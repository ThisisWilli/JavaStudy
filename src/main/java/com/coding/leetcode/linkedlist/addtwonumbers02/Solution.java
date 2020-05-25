package com.coding.leetcode.linkedlist.addtwonumbers02;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.linkedlist.addtwonumbers02
 * \* author: Willi Wei
 * \* date: 2020-05-24 21:58:04
 * \* description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * \
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        // l1, l2的长度可能不同，要注意处理某个链表剩余的高位

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int add = 0;
        while (l1 != null || l2 != null){
            int temp = 0, sum = 0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if (add > 0){
                sum += add;
                add--;
            }
            if (sum > 10){
                sum = sum % 10;
                add++;
            }
            ListNode node = new ListNode(sum);
            head.next = node;
            head = node;
        }

        if (add > 0){
            head.next = new ListNode(1);
        }

        return dummy.next;
    }
}