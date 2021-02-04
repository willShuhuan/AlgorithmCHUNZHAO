package entity;

/**
 * @author DSH
 * @date 2021/1/25
 * @description
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    @Override
//    public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                '}';
//    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}