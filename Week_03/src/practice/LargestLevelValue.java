package practice;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #515 在每个树行中找到最大值
 * 微软 亚马逊 facebook
 */
public class LargestLevelValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(largestLevelValue(root));
    }

    //方法一 BFS
    public static List<Integer> largestLevelValue(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                max = Math.max(max,node.val);
                if (node.left!=null){
                    nodes.offer(node.left);
                }
                if (node.right!=null){
                    nodes.offer(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }

}
