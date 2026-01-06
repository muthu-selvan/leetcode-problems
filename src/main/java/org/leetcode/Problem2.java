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
        List<Integer> fromFistNode = getNumberFromNode(l1);
        List<Integer> fromSecondNode = getNumberFromNode(l2).reversed();
        int totalSum = getNumberValueFromList(fromFistNode) +
                getNumberValueFromList(fromSecondNode);
        
        return getReversedLinkedList(totalSum);
    }
    
    private ListNode getReversedLinkedList(int number) {
        ListNode node = null;
        
        while (number != 0) {
            int modValue = number%10;
            
            if (node == null) {
                node = new ListNode(modValue);
            } else {
                node.next = new ListNode(modValue);
            }

            number = number/10;
        }
        
        return node;
    }
    
    private int getNumberValueFromList(List<Integer> list) {
        int sum = 0;
        
        for (int i : list) {
            sum += i*10;
        }
        return sum;
    }

    private List<Integer> getNumberFromNode(ListNode l1) {
        List<Integer> result = new ArrayList<>();

        while (l1 != null) {
            result.add(l1.val);
            l1 = l1.next;
        }

        return result;
    }

    private ListNode prepareListNode(int[] num) {
        ListNode node = null;

        for (int i = 0; i< num.length; i++) {

            if (node == null) {
                node = new ListNode(num[i]);
            } else {
                node.next = new ListNode(num[i]);
            }
        }

        return node;
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
