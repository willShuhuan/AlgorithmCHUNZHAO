package homework;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/2
 * @description 二叉树中序遍历
 */
public class BinaryTreeInOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }

    //中序遍历 左根右
    private static void helper(TreeNode root, List<Integer> list) {
        if (root!=null){
            helper(root.left,list);
            list.add(root.val);
            helper(root.right,list);
        }
    }

}
