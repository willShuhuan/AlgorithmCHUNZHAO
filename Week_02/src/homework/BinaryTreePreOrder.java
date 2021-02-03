package homework;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/2
 * @description 二叉树前序遍历
 */
public class BinaryTreePreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        System.out.println(preOrderTraversal(root));
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }

    //前序遍历 根左右
    private static void helper(TreeNode root, List<Integer> list) {
        if (root!=null){
            list.add(root.val);
            helper(root.left,list);
            helper(root.right,list);
        }
    }
}
