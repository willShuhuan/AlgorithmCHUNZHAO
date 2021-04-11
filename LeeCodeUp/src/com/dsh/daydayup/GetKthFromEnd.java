package com.dsh.daydayup;

import java.util.HashSet;

/**
 * @author DSH
 * @date 2021/4/6
 * @description 剑指offer22 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class GetKthFromEnd {

    public static void main(String[] args) {
        ListNode root = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(getKthFromEnd(root, 2));
        System.out.println(getKthFromEnd2(root, 2));
    }

    //笨方法
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = head;
        int count = 0;
        while (head!=null){
            count++;
            head = head.next;
        }
        int flag = 0;
        while (flag<count-k){
            res = res.next;
            flag++;
        }
        return res;
    }

    //双指针法
    //快慢指针步幅差为k，former为null时，latter就是返回结果
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head,latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former!=null){
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }

}
