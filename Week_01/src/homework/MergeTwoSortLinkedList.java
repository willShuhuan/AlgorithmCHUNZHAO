package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DSH
 * @date 2021/1/22
 * @description #21 合并两个有序链表
 */
public class MergeTwoSortLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
//        ListNode result = mergeTwoLists(l1,l2);
        ListNode result = mergeTwoLists2(l1,l2);
        System.out.println(result);

    }

    //自己想的笨方法，将nodes节点排序后添加到数组中，然后从后向前遍历数组next赋值，从而构造链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<ListNode> nodes = new ArrayList<>();
        while(l1!=null&&l2!=null){
            ListNode cur = null;
            if (l1==null){
                cur = new ListNode(l2.val,null);
                l2=l2.next;
            } else if (l2==null){
                cur = new ListNode(l1.val,null);
                l1=l1.next;
            }
            else if (l1.val<l2.val){
                cur = new ListNode(l1.val,null);
                l1=l1.next;
            }else{
                cur = new ListNode(l2.val,null);
                l2 = l2.next;
            }
            nodes.add(cur);
        }
        if (nodes.size()>0){
            int i = nodes.size()-1;
            while(i>0){
                nodes.get(i-1).next = nodes.get(i);
                i--;
            }
            return nodes.get(0);
        }else {
            return null;
        }


    }

    //通过循环遍历，不断找到两个链上的较小节点，把next指向较小的节点
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                prev.next = l1;
                l1=l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
//            System.out.println("prev=====  "+prev);
//            System.out.println("preHead==  "+preHead.next);
        }
        prev.next = l1 == null ? l2 : l1;
//        System.out.println(prev);
//        System.out.println("preHead=="+preHead);
        return preHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}