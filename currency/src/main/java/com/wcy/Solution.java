package com.wcy;

/**
 * @auth wcy on 2020/1/13.
 */
public class Solution {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {
       ListNode l1 = new ListNode(2);
        ListNode t1 = new ListNode(4);
        ListNode t2 = new ListNode(3);
        l1.next = t1;
        t1.next = t2;

        ListNode l2 = new ListNode(5);
        ListNode t21 = new ListNode(6);
        ListNode t22 = new ListNode(4);
        l2.next = t21;
        t21.next = t22;

        ListNode root = addTwoNumbers(l1,l2);
        do{
            System.out.println(root.val);
            root = root.next;
        }while (root != null);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        test(l1,l2,root,0);
        return root.next;
    }

    public  static void test(ListNode l1, ListNode l2, ListNode res, int carry){
                int val1 = l1 != null ? l1.val : 0;
                int val2 = l2 != null ? l2.val : 0;
                int sum = val1 + val2 + carry;
                carry = sum / 10;
                ListNode resultNext = new ListNode(sum % 10);
                res.next = resultNext;

                ListNode next1 = null;
                ListNode next2 = null;
                if(l1 != null){
                    next1 = l1.next;
                }
                if(l2 != null){
                    next2 = l2.next;
                }
                if(next1 != null || next2 != null){
                    test(next1 , next2, resultNext,carry);
                }else if(carry > 0) {
                    resultNext.next = new ListNode(carry);
                }

    }
}
