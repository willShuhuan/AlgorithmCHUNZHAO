package com.dsh.daydayup;

/**
 * @author DSH
 * @date 2021/4/6
 * @description 148 排序链表
 * https://leetcode-cn.com/problems/sort-list/submissions/
 */
public class SortLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));
        System.out.println(sortList(node));
    }

    //采用官方题解
    public static ListNode sortList(ListNode head) {
        return sortMerge(head,null);
    }

    private static ListNode sortMerge(ListNode head, ListNode tail) {
        if (head==null) return head;
        if (head.next==tail){
            head.next = null;
            return  head;
        }
        ListNode fast = head,slow = head;
        while (fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if (fast!=tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode l1 = sortMerge(head,mid);
        ListNode l2 = sortMerge(mid,tail);
        return merge(l1,l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        System.out.println("l1=="+l1);
        System.out.println("l2=="+l2);
        ListNode node = new ListNode(-1);//构建一个哑节点
        ListNode tmp = node;//临时指针
        ListNode tmp1 = l1;//l1临时指针
        ListNode tmp2 = l2;//l2临时指针
        while (tmp1!=null&&tmp2!=null){
            if (tmp1.val<tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }else {
                tmp.next = tmp2;
                tmp2=tmp2.next;
            }
            tmp = tmp.next;
        }
        if (tmp1!=null){
            tmp.next = tmp1;
        }
        if (tmp2!=null){
            tmp.next = tmp2;
        }
        System.out.println("merger result=="+node.next);
        return node.next;
    }
}
