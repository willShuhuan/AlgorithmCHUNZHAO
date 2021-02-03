package homework;

import entity.Nnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/2/2
 * @description N叉树前序遍历
 */
public class NTreePreOrder {
    public static void main(String[] args) {
        Nnode node = new Nnode(1,new ArrayList(){
            {
                add(new Nnode(3,new ArrayList(){
                    {
                        add(new Nnode(5,null));
                        add(new Nnode(6,null));
                    }
                }));
                add(new Nnode(2,null));
                add(new Nnode(4,null));
            }
        });
        System.out.println(node);
        preorder(node);
        System.out.println(list);
    }

    static List<Integer> list = new ArrayList<>();
    private static void preorder(Nnode node) {
        if (node!=null){
            list.add(node.val);
            if (node.children!=null){
                for (Nnode child:node.children) {
                    preorder(child);
                }
            }

        }
    }
}
