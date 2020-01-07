package com.coding.sword.tree.hasSubTree;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.tree.hasSubTree
 * \* author: Willi Wei
 * \* date: 2020-01-07 14:27:37
 * \* description:输入两棵二叉树A，B，判断B是不是A的子结构  (空树不是任意一个树的子结构)
 * \
 */
class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 1.首先设置标志位result = false，因为一旦匹配成功result就设为true，剩下的代码不会执行，如果匹配不成功，默认返回false
     * 2.递归思想，如果根节点相同则递归调用help函数，如果根节点不同，则判断tree1的左子树和tree2是否相同，在判断tree1的右子树和tree2
     *  是否相同。
     * 3.注意null的条件，help函数中，如果两棵树都不为空才进行判断，help函数中，如果第二棵树遍历完了，则匹配成功，tree1为空有两种情况
     *      1.如果tree1为空&&tree2不为空说明不匹配
     *      2.如果tree1为空&&tree2为空，说明匹配
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = DoesTree1HasTree2(root1, root2);
            }
            if (!result){
                result = HasSubtree(root1.left, root2);
            }
            if (!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2){
        // 如果tree1为空，tree2不为空，说明匹配失败
        if (root1 == null && root2 != null){
            return false;
        }
        // root2为空，说明匹配成功
        if (root2 == null){
            return true;
        }
        if (root1.val != root2.val){
            return false;
        }
        return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
    }
}