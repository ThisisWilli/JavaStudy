package com.coding.sword2nd.linkedlist.copyrandomlist35;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.linkedlist.copyrandomlist35
 * \* author: Willi Wei
 * \* date: 2020-07-03 09:43:02
 * \* description:
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * \
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node p = head;

        // 在每个node后面创建一个新的node
        while (p != null){
            Node newNode = new Node(p.val);
            newNode.next = p.next;
//            newNode.random = p.random;
            p.next = newNode;
            p = newNode.next;
        }

        // 将每个新的node结点连接到新的random
        p = head;
        while (p != null){
            if (p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        Node result = head.next;
        p = head;
        Node q = head.next;
        while (p != null){
            p.next = p.next.next;
            if (q.next == null){
                break;
            }
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }

        return result;
    }
}