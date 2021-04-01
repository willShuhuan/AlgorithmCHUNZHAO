package dsh.leetcode;

import java.util.List;

/**
 * LeetCode 98 验证二叉搜索树
 * @author DSH
 * @date 2020/12/8
 * @description
 */
public class VerifyBTS {

    public static void main(String[] args) {
        Node parent = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        node1.val = 1;
        node2.val = 3;
        parent.val = 2;
        parent.left = node1;
        parent.right = node2;
        System.out.println(infixOrder(parent));
    }

    private static Integer last;
    public static boolean infixOrder(Node root){
        if(root==null){
            return true;
        }
        if(!infixOrder(root.left)) return false;
        if(last!=null){
            if(root.val<=last){
                return false;
            }
        }
        last = root.val;
        if (!infixOrder(root.right)) return false;
        return true;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }


    };
}
