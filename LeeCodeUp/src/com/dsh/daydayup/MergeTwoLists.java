package com.dsh.daydayup;


/**
 * @author DSH
 * @date 2021/4/1
 * @description 合并两个有序链表
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while(l1!=null&&l2!=null){
            if (l1.val<l2.val){
                pre.next = l1;
                l1=l1.next;
            }else {
                pre.next = l2;
                l2=l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null?l2:l1;
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