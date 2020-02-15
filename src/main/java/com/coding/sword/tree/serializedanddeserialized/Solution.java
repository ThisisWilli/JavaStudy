package com.coding.sword.tree.serializedanddeserialized;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-15 09:35
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
    /**
     * 序列化二叉树
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuffer str= new StringBuffer();
        if (root == null){
            str.append("#,");
            return str.toString();
        }
        str.append(root.val).append(",");
        str.append(Serialize(root.left));
        str.append(Serialize(root.right));
        return str.toString();
    }

    /**
     * 反序列化二叉树
     * @param str {1, 2, 4, #, #, #, 3, 5, #, #, 6, #, #}
     * @return
     */
    private int index = -1;
    TreeNode Deserialize(String str) {
        // 如果没有碰到两个 # 则还没有大到达叶子节点
        index++;
        String[] split = str.split(",");
        TreeNode root = null;
        if (!split[index].equals("#")){
            root = new TreeNode(Integer.parseInt(split[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}
