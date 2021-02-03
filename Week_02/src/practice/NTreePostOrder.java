package practice;

import entity.Nnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/1/26
 * @description #590 N叉树的后序遍历
 */
public class NTreePostOrder {
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
        postorder(node);
        System.out.println(list);

    }

    static List<Integer> list = new ArrayList<>();
    public static List<Integer> postorder(Nnode root) {
        if(root!=null){
            if(root.children!=null&&root.children.size()>0){
                for(Nnode node:root.children){
                    System.out.println(node.val);
                    postorder(node);
                }
            }
            list.add(root.val);
        }
        return list;
    }
}
