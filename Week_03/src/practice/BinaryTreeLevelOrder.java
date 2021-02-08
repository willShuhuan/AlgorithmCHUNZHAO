package practice;


import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #102 二叉树层序遍历
 * 字节跳动 亚马逊 微软
 */
public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                            new TreeNode(9),
                            new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(levelOrder(root));
    }

    //方法一 BFS
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                level.add(node.val);
                if (node.left!=null){
                    nodes.offer(node.left);
                }
                if (node.right!=null){
                    nodes.offer(node.right);
                }
            }
            ans.add(level);
        }

        return ans;
    }

}
