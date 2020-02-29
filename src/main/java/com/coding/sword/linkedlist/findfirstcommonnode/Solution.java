package com.coding.sword.linkedlist.findfirstcommonnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-29 09:10
 **/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的
 * 利用双指针解题是不行的，因为两个链表不是一样长的，可以用stack解题，从链表尾部开始判断
 */
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        List<ListNode> result = new ArrayList<>();
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (pHead1 != null && pHead2 != null){
            s1.push(pHead1);
            s2.push(pHead2);
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        while (pHead1 != null){
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }

        while (!s1.isEmpty() && !s2.isEmpty()){
            ListNode l1 = s1.pop();
            ListNode l2 = s2.pop();
            if (l1 == l2){
                result.add(l1);
            }
        }
        if (result.size() == 0){
            return null;
        }else {
            return result.get(result.size() - 1);
        }
    }
}
