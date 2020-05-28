package com.coding.leetcode.linkedlist.insertionsortlist147;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.linkedlist.insertionsortlist147
 * \* author: Willi Wei
 * \* date: 2020-05-26 16:00:35
 * \* description:
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * \
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    /**
     * 1、需要指定两个节点，一个节点指向已经排序好的节点的最后一个节点
     * 2、每次指向一个新的节点，先和前驱比较，如果大于等于前驱，那么直接进行下一次循环，如果小于前驱节点，那么从指向头节点的那个节点开始遍历
     * 3、如果前驱较小，进入内层循环，依次和pre指针进行比较，插入对应位置
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = new ListNode(0);
        while (head != null && head.next != null){
            if (head.next.val >= head.val){
                head = head.next;
                continue;
            }

            pre = dummy;
            while (pre.next.val < head.next.val){
                pre = pre.next;
            }

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}