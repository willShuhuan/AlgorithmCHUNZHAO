package practice;


import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/1/25
 * @description #144 二叉树前序遍历
 */
public class BinaryTreePreOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
//        List<Integer> integers = preorderTraversal(root);
        List<Integer> integers = preorderTraversal2(root);
        System.out.println(integers);
    }

    static List<Integer> list = new ArrayList<>();
    // 递归方式解决
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root!=null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }

    //循环迭代方式
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root!=null){
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            //模拟递归中的栈结构
            while (!stack.isEmpty()||node!=null){
                while (node!=null){
                    list.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();//左节点遍历到头了，弹出上级节点，遍历其右节点
                node = node.right;
            }
        }
        return list;
    }
}
