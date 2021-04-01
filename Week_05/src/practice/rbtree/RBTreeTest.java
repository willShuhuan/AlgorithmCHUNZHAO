package practice.rbtree;

import java.util.Scanner;

/**
 * @author DSH
 * @date 2021/3/29
 * @description
 */
public class RBTreeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RBTree<String,Object> rbt = new RBTree();
        while (true){
            System.out.println("请输入key：");
            String key = scanner.next();
            System.out.println();
            rbt.insert(key,null);
            TreeOperation.show(rbt.getRoot());
        }
    }
}
