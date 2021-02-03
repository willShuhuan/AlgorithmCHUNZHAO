package practice;

import entity.Nnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/1/26
 * @description #589 N叉树的前序遍历
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
        System.out.println(preorder(node));

    }

    public static List<Integer> preorder(Nnode root) {
        List<Integer> list = new ArrayList<>();
        helper(list,root);
        return list;
    }

    public static void helper(List list,Nnode root){
        if(root!=null){
            list.add(root.val);
            if(root.children!=null&&root.children.size()>0){
                for(Nnode n : root.children){
                    helper(list,n);
                }
            }
        }
    }
}
