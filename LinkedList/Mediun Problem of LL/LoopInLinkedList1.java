/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some Node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false. 
*/

import java.util.*;
class ListNode {
    int data;
    ListNode next;
    ListNode(int value) {
        data = value;
        next = null;
    }
}

class Solution{
    
    ListNode arrayToLinkedList(int[] arr) {
        if(arr.length == 0 || arr == null) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            current.next = temp;
            current = temp;
        }

        return head;
    
    }

    boolean checkloop(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    //Brute Solution
    boolean hasCycleBrute(ListNode head) {
        
        ListNode temp = head;

        HashMap<ListNode,Integer> nodeMap = new HashMap<>();

        while(temp != null){
            
            if(nodeMap.containsKey(temp)){
                return true;
            }
            nodeMap.put(temp,1);

            temp = temp.next;   
        }

        return false;
    
    }
}

public class LoopInLinkedList1 {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {3,2,0,-4};
        ListNode head = sol.arrayToLinkedList(arr);
        
        // Create a loop for testing
        if (head != null && head.next != null) {
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = head.next;
        }

        boolean hasLoop = sol.checkloop(head);
        if (hasLoop) {
            System.out.println("The linked list has a cycle.");
        } else {
            System.out.println("The linked list does not have a cycle.");
        }
    }
}