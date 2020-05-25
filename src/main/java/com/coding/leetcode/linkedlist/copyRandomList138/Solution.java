package com.coding.leetcode.linkedlist.copyRandomList138;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.linkedlist.copyRandomList138
 * \* author: Willi Wei
 * \* date: 2020-05-25 09:21:33
 * \* description:
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：

 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：

 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。

 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
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
    /**
     * 方法一：创建一个HashMap，第一遍遍历在map中存放旧节点对应新节点，因为那是还无法访问random节点，第二遍遍历以为map已经存放了每个next
     * 节点和每个random节点，遍历时就可以在map中取出next节点和random节点，完成新链表的构建
     * 方法二：在旧节点后面复制一个一模一样的节点，模拟map的过程
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        // 如果head为null
        if (head == null){
            return head;
        }
        Node p = head;
        while (p != null){
            Node copyNode = new Node(p.val);
            copyNode.next = p.next;
            p.next = copyNode;
            p = copyNode.next;
        }

        p = head;
        while (p != null){
            if (p.random != null){
                p.next.random = p.random.next;
            }

            p = p.next.next;
        }

        p = head;
        Node head2 = head.next;
        Node q = head2;
        while (p != null){
            p.next = p.next.next;
            if (q.next == null){
                break;
            }
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }

        return head2;
    }
}