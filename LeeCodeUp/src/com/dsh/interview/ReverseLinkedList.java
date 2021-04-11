package com.dsh.interview;

import com.dsh.model.ListNode;

/**
 * @author DSH
 * @date 2021/4/2
 * @description 剑指offer24 反转链表  leetcode 206
 * 2021 字节跳动面试真题
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(reverseList(node));
    }

    //双指针
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;//当前遍历的节点
        while (cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;//第一次：1->null   第二次： 2->1->null
            pre = cur;//第一次： 1->null       第二次： 2->1->null
            cur = nxt;//第一次：2->3->4->5->null 第二次：3->4->5->null
        }
        return pre;
    }

}
