package com.dsh.daydayup;

import java.util.HashSet;

/**
 * @author DSH
 * @date 2021/4/6
 * @description 141 环形链表 判断链表上是否有环
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class IsCycleLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3,new ListNode(2,new ListNode(0,new ListNode(-4))));
        //测试用例想了半天没写出来
    }

    //方法1：哈希表遍历，判断此前节点是否被访问过，访问过说明已存在->是环形链表
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }

    //方法2 快慢指针 慢指针每次移动一位，快指针每次移动两位
    public boolean hasCycle2(ListNode head) {
        if (head==null||head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast){
            if (fast==null||fast.next==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
