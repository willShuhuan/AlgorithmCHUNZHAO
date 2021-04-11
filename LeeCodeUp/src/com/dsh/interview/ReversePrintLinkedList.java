package com.dsh.interview;

import com.dsh.model.ListNode;

import java.util.Stack;

/**
 * @author DSH
 * @date 2021/4/2
 * @description leetcode 1265 逆序打印不可变链表
 * 2021字节面试真题
 */
public class ReversePrintLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        reversePrint(node);
    }

    private static void reversePrint(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node!=null){
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
