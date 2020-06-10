package com.coding.leetcode.tree.pathsum437;
/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.tree.pathsum437
 * \* author: Willi Wei
 * \* date: 2020-05-30 14:22:33
 * \* description:
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * \
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    /**
     * 先遍历到最后一个几点
     * @param root
     * @param sum
     * @return
     */

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int result = countPath(root,sum);
        int a = pathSum(root.left,sum);
        int b = pathSum(root.right,sum);
        return result+a+b;
    }

    private int countPath(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        sum -= root.val;
        int result = sum == 0 ? 1 : 0;
        return result + countPath(root.left, sum) + countPath(root.right, sum);
    }

}