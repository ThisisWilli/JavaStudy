package com.coding.sword.tree.issymmetrical;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-12 09:45
 **/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        return judgeSymmetrical(pRoot, pRoot);
    }

    private boolean judgeSymmetrical(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return judgeSymmetrical(left.left, right.right) && judgeSymmetrical(left.right, right.left);
    }
}
