package homework;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/2
 * @description 二叉树后序遍历
 */
public class BinaryTreePostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        System.out.println(postOrderTraversal(root));
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }

    //后序遍历 左右跟
    private static void helper(TreeNode root, List<Integer> list) {
        if (root!=null){
            helper(root.left,list);
            helper(root.right,list);
            list.add(root.val);
        }
    }
}
