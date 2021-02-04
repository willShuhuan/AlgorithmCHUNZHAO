package practice;

import entity.TreeNode;

/**
 * @author DSH
 * @date 2021/2/3
 * @description leetcode #226
 * 翻转二叉树
 */
public class InvertTree {
    //TODO 看题解
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,new TreeNode(1),new TreeNode(3)),
                new TreeNode(7,new TreeNode(6),new TreeNode(9)));
        invertTree(root);
        System.out.println(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
