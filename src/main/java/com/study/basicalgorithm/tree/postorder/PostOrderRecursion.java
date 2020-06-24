package com.study.basicalgorithm.tree.postorder;

import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.study.basicalgorithm.tree.postorder
 * \* author: Willi Wei
 * \* date: 2020-06-24 11:29:41
 * \* description:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PostOrderRecursion {

    public List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode root){
        if (root == null){
            return;
        }
        helper(root.left);
        helper(root.right);
        result.add(root.val);
    }

}