package com.coding.sword2nd.tree.issubstructure26;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.tree.issubstructure26
 * \* author: Willi Wei
 * \* date: 2020-06-29 10:07:10
 * \* description:
 * \输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }

        return findSame(A, B);
    }

    public boolean findSame(TreeNode a, TreeNode b){
        boolean left = false;
        boolean right = false;
        boolean one = false;
        if (a.val == b.val){
            one = isSame(a, b);
        }

        if (a.left != null){
            left = findSame(a.left, b);
        }

        if (a.right != null){
            right = findSame(a.right, b);
        }

        return left || right || one;
    }

    public boolean isSame(TreeNode a, TreeNode b){
        if (a == null && b == null || a != null && b == null){
            return true;
        }
        if (a == null){
            return false;
        }
        if (a.val != b.val){
            return false;
        }

        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}