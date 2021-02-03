package homework;

import entity.TreeNode;

/**
 * @author DSH
 * @date 2021/2/2
 * @description leetCode 236 二叉树最近公共祖先
 * FaceBook面试题
 */
public class BinaryTreeLowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(0);
        TreeNode root = new TreeNode(3,
                new TreeNode(5,p,new TreeNode(2,new TreeNode(7),new TreeNode(4))),
                new TreeNode(1,q,new TreeNode(8)));
        TreeNode node = lowestCommonAncestor(root,p,q);
        System.out.println(node);
    }

    //TODO week2 二叉树最近公共祖先 后序遍历DFS  不太理解 回来要复习一下
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||p==root||q==root) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null) return null;//这一行要加上 效率高很多
        if (left==null) return right;
        if (right==null) return left;
        return root;
    }

}
