package homework;

import entity.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DSH
 * @date 2021/2/2
 * @description LeetCode #105 从前序与中序遍历序列构造二叉树
 * 字节、亚马逊、微软面试题
 */
public class BuildTree {
    public static void main(String[] args) {
//        int[] preOrder = {3,9,20,15,7};
//        int[] inOrder = {9,3,15,20,7};
        int[] preOrder = {1,2};
        int[] inOrder = {1,2};
//        System.out.println(buildTree(preOrder, inOrder));
        System.out.println(buildTree2(preOrder, inOrder));
    }

    //方法1 递归
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0||inorder.length==0) return null;
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            //找到根节点对应的中序遍历数组中的位置
            if (inorder[i]==preorder[0]){
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] p_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] p_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,preorder.length);
                //左子树
                root.left = buildTree(p_left,in_left);
                //右子树
                root.right = buildTree(p_right,in_right);
            }
        }
        return root;
    }

    //TODO week2 构造二叉树 不太理解
    //方法2 基于第一种解法的优化，使用map记录中序遍历的根索引
    //第一种解法每一次都要遍历数组找到跟索引index
    //不如用map把index存起来，这样省了很多循环
    private static TreeNode buildTree2(int[] preOrder, int[] inOrder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i],i);
        }
        int size = preOrder.length;
        return helper(preOrder,inOrder,map,0,size-1,0,size-1);
    }

    private static TreeNode helper(int[] preOrder, int[] inOrder, Map<Integer, Integer> map,int p_start,int p_end,int i_start,int i_end) {
        if (p_start>p_end) return null;
        int rootVal = preOrder[p_start];
        TreeNode root = new TreeNode(rootVal);
        int indexRoot = map.get(rootVal);//中序数组根索引
        root.left = helper(preOrder,inOrder,map,p_start+1,indexRoot+p_start-i_start,i_start,indexRoot-1);
        root.right = helper(preOrder,inOrder,map,p_start+indexRoot-i_start+1,p_end,indexRoot+1,i_end);
        return root;
    }


}
