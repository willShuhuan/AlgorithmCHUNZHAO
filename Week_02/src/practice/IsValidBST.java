package practice;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/4
 * @description LeetCode #98 验证二叉搜索树
 * 字节跳动面试题
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode realBts = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        TreeNode fakeBts = new TreeNode(5,
                            new TreeNode(1),
                            new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        System.out.println(isValidBTS(realBts));
        System.out.println(isValidBTS(fakeBts));
        System.out.println(isValidBTS2(realBts));
        System.out.println(isValidBTS2(fakeBts));
    }

    //利用中序遍历时升序排列的特点
    //方法一 遍历一遍，看数组是不是升序排列的
    private static boolean isValidBTS(TreeNode root) {
        if (root==null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    private static List<Integer> inOrder(TreeNode root, List<Integer> list) {
        if (root!=null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right,list);
        }
        return list;
    }

    //方法2  效率提升 只要遍历到的下一个节点比上一个节点小 就返回false
    static long last = Long.MIN_VALUE;
    private static boolean isValidBTS2(TreeNode root) {
        if (root==null){
            return true;
        }
        //左子树验证
        if(!isValidBTS2(root.left)){
            return false;
        }
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历
        if (root.val<=last){
            return false;
        }
        last = root.val;
        //验证右节点
        if(!isValidBTS2(root.right)){
            return false;
        }
        return true;
    }

}
