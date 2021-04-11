package com.dsh.interview;

import com.dsh.model.TreeNode;

/**
 * @author DSH
 * @date 2021/4/2
 * @description leetcode236 二叉树最近公共祖先
 * 2021 字节面试真题
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(0);
        TreeNode root = new TreeNode(3,
                new TreeNode(5,p,new TreeNode(2,new TreeNode(7),new TreeNode(4))),
                new TreeNode(1,q,new TreeNode(8)));
        TreeNode node = lowestCommonAncestor(root,p,q);
        System.out.println(node.val);
    }

    //todo dfs必须会
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left==null&&right==null) return null;
        if (left==null) return right;
        if (right==null) return left;
        return root;
    }
}
