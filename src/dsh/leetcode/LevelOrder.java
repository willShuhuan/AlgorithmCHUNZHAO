package dsh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 429 N叉树的层序遍历
 * @author DSH
 * @date 2020/12/8
 * @description
 */
public class LevelOrder {

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        List<Node> children = new ArrayList<>();
        children.add(node1);
        children.add(node2);
        children.add(node3);
        Node node = new Node(1,children);
        Solution solution = new Solution();
        solution.levelOrder(node);
    }

}

class Node {
   public int val;
   public List<Node> children;

   public Node() {}

   public Node(int _val) {
       val = _val;
   }

   public Node(int _val, List<Node> _children) {
       val = _val;
       children = _children;
   }
};
 class Solution {
    List<List<Integer>> list = new ArrayList<>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    int level = 0;
    public List<List<Integer>> levelOrder(Node root) {
        helper(root,level);
        for(Integer index : map.keySet()){
            list.add(map.get(index));
        }
        return list;
    }

    private void helper(Node root,int level){
        if(root!=null){
            List<Integer> subList = map.get(level);
            if(subList==null){
                subList = new ArrayList<>();
            }
            subList.add(root.val);
            map.put(level,subList);
            level++;
            if(root.children!=null&&root.children.size()>0){
                for(Node node:root.children){
                    helper(node,level);
                }
            }
        }
    }
}