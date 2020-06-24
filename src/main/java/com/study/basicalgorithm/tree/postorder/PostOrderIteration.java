package com.study.basicalgorithm.tree.postorder;

import java.util.*;

/**
 * \* project: JavaStudy
 * \* package: com.study.basicalgorithm.tree.postorder
 * \* author: Willi Wei
 * \* date: 2020-06-24 13:14:46
 * \* description:
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * \
 */
public class PostOrderIteration {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return result;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            // 每次相当于都拿一个头节点，因为头节点都是最后访问，所以先放到最后，然后
            TreeNode node = stack.pollLast();
            // 每次都从队头插入结果，这样会有一个逆序的效果
            result.offerFirst(node.val);
            if (node.left != null){
                stack.offerLast(node.left);
            }

            if (node.right != null){
                stack.offerLast(node.right);
            }
        }
        return result;
    }
}