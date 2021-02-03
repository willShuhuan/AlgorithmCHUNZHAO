package homework;

import entity.Nnode;

import java.util.*;

/**
 * @author DSH
 * @date 2021/2/2
 * @description N叉树层序遍历 LeetCode 429
 */
public class NTreeLevelOrder {
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
//        System.out.println(nTreeLevelOrder(node));
//        System.out.println(nTreeLevelOrder2(node));
        System.out.println(nTreeLevelOrder3(node));
    }




    //方法1 笨方法 利用map的特性（看了题解 这个解法太垃圾了）
    static int level = 0;
    static List<List<Integer>> list = new ArrayList<>();
    static Map<Integer,List<Integer>> map = new HashMap<>();
    private static List<List<Integer>> nTreeLevelOrder(Nnode node) {
        helper(node,level);
        for (Integer key:map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }
    private static void helper(Nnode node, int level) {
        if (node!=null){
            List<Integer> list = map.get(level);
            if (list==null){
                list = new ArrayList<>();
            }
            list.add(node.val);
            map.put(level,list);
            level++;
            if (node.children!=null){
                for (Nnode child: node.children) {
                    helper(child,level);
                }
            }
        }
    }

    //递归方式 简单易理解
    private static List<List<Integer>> nTreeLevelOrder2(Nnode node) {
        helper2(node,level);
        return list;
    }
    private static void helper2(Nnode node, int level) {
        if(node!=null){
            if (list.size()<=level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.val);
            if (node.children!=null){
                for (Nnode child: node.children) {
                    helper2(child,level+1);
                }
            }
        }
    }

    //方法2 利用队列解决 这个是更优解
    private static List<List<Integer>> nTreeLevelOrder3(Nnode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;
        Queue<Nnode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Nnode node = queue.poll();
                level.add(node.val);
                if(node.children!=null){
                    queue.addAll(node.children);
                }
            }
            result.add(level);
        }
        return result;
    }

    //TODO week2 N叉树层序遍历 方法3 广度优先搜索搜索 学习后添加代码

}
