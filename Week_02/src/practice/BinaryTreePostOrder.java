package practice;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DSH
 * @date 2021/1/25
 * @description 二叉树后续遍历
 */
public class BinaryTreePostOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
//        List<Integer> integers = postOrderTraversal(root);
        List<Integer> integers = postOrderTraversal2(root);
        System.out.println(integers);
    }

    static List<Integer> list = new ArrayList<>();
    //递归方式
    private static List<Integer> postOrderTraversal(TreeNode root) {
        if (root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }

    //模拟栈结构的迭代方式
    private static List<Integer> postOrderTraversal2(TreeNode root) {
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while(!stack.isEmpty()||root!=null){
                while (root!=null) {
                    stack.push(root);
                    if (root.left==null){
                        prev = root;
                    }
                    root = root.left;
                }
                root = stack.pop();
                while (root!=null) {
                    stack.push(root);
                    root = root.right;
                }
//                stack.push(root);
                root = stack.pop();
            }
            System.out.println(stack);
        }
        return list;
    }

}
