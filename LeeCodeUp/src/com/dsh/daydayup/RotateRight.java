package com.dsh.daydayup;

/**
 * @author DSH
 * @date 2021/4/15
 * @description leetCode61 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(rotateRight(node, 2));
    }

    //TODO 整明白旋转链表这个题目
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 计算有效的 k 值：对于与链表长度成整数倍的「旋转」都是没有意义的（旋转前后链表不变）
        int tot = 0;
        ListNode tmp = head;
        while (tmp != null && ++tot > 0) tmp = tmp.next;
        k %= tot;
        if (k == 0) return head;

        ListNode fast = head,slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next=null;
        fast.next = head;

        return newHead;
    }

}
