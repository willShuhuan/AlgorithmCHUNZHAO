package practice;


import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author DSH
 * @date 2021/1/25
 * @description #94 二叉树中序遍历
 */
public class BinaryTreeInOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
//        List<Integer> integers = inorderTraversal(root);
        List<Integer> integers = inorderTraversal2(root);
        System.out.println(integers);
    }

    static List<Integer> list = new ArrayList<>();
    // 递归式
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root!=null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }

    // 循环迭代，模拟栈结构
    private static List<Integer> inorderTraversal2(TreeNode root) {
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty()||root!=null){
                while (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

}
