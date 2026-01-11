package org.leetcode;

import java.util.ArrayList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int reminder = 0;
       ListNode result = null;
       ListNode current = null;

       while(l1 != null || l2 != null || reminder != 0) {
           int firstNodeValue =  l1 != null ? l1.val : 0;
           int secondNodeValue = l2 != null ? l2.val : 0;

           int sum = reminder + firstNodeValue + secondNodeValue;
           int valueToStore = sum % 10;

           if (current == null) {
               result = new ListNode(valueToStore);
               current = result;
           } else {
               current.next = new ListNode(valueToStore);
               current = current.next;
           }
           reminder = sum / 10;

           l1 = l1 != null ?  l1.next : null;
           l2 = l2 != null ? l2.next : null;
       }

       return result;
    }

    private ListNode prepareListNode(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }

        ListNode head = new ListNode(num[0]);
        ListNode current = head;

        for (int i = 1; i < num.length; i++) {
            current.next = new ListNode(num[i]);
            current = current.next;
        }

        return head;
    }

    private void printListNode(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val+",");
            node = node.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};

        ListNode listNode = problem2.addTwoNumbers(problem2.prepareListNode(arr1), problem2.prepareListNode(arr2));
        problem2.printListNode(listNode);
    }


}
