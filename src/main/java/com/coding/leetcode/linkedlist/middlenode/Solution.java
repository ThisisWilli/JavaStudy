package com.coding.leetcode.linkedlist.middlenode;

import java.util.Vector;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-23 09:11
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 **/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null){
            return head;
        }
        Vector<ListNode> nodes = new Vector<>();

        while (head != null){
            nodes.add(head);
            head = head.next;
        }

        return nodes.get(nodes.size() / 2);
    }
}
