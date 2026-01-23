import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int value) {
        val = value;
        next = null;
    }
}

class Solution {
    
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

    public boolean isPalindrome(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;

        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revhead = reverseList(slow);

        ListNode temp = head;
        ListNode temp1 = revhead;
        while(temp1 != null){
            if(temp.val != temp1.val){
                return false;
            }
            temp = temp.next;
            temp1 = temp1.next;
        }

        reverseList(revhead);
        return true;

    }

    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){

            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;

    }

    //Brute Solution
    public boolean isPalindromeBrute(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp!=null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            
            if(temp.val != stack.pop()){
                return false;
            }
            
            temp = temp.next;
        }
        return true;

    }
}

public class PalindromeLL {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {1, 2, 2, 1};
        ListNode head = sol.arrayToLinkedList(arr);
        
        boolean isPalin = sol.isPalindrome(head);
        if (isPalin) {
            System.out.println("Optimal: The linked list is a palindrome.");
        } else {
            System.out.println("Optimal: The linked list is not a palindrome.");
        }

    //     head = sol.arrayToLinkedList(arr);
    //     boolean isPalinBrute = sol.isPalindromeBrute(head);
    //     if (isPalinBrute) {
    //         System.out.println("Brute: The linked list is a palindrome.");
    //     } else {
    //         System.out.println("Brute: The linked list is not a palindrome.");
    //     }
    }
}
