import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
        this.val = 0;
        this.next = null;
    }
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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

    void displayList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Optimal Solution - Single Pass with Carry
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        boolean carry = false;
        
        while(l1!=null && l2!=null){
            int data;
            if(carry){
                data = l1.val + l2.val+1;
            }else{
                data = l1.val+l2.val;
            }
            if(data > 9){
                carry = true;
                data = data % 10;
            }
            else{
                carry = false;
            }

            ListNode newnode = new ListNode(data,null);
            temp.next = newnode;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int data;
            if(carry){
                data = l1.val+1;
            } else{
                data = l1.val;
            }
            if(data > 9){
                carry = true;
                data = data % 10;
            }
            else{
                carry = false;
            }
            ListNode newnode = new ListNode(data,null);
            temp.next = newnode;
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int data;
            if(carry){
                data = l2.val+1;
            } else{
                data = l2.val;
            }
            if(data > 9){
                carry = true;
                data = data % 10;
            }
            else{
                carry = false;
            }

            ListNode newnode = new ListNode(data,null);
            temp.next = newnode;
            temp = temp.next;
            l2 = l2.next;
        }

        if(carry){
            ListNode newnode = new ListNode(1,null);
            temp.next = newnode;
        }

        return dummy.next;
    }

    //Brute Solution - Extract, Add Numbers, Create Result List
    public ListNode addTwoNumbersBrute(ListNode l1, ListNode l2) {
        
        long num1 = 0, num2 = 0;
        ListNode temp1 = l1, temp2 = l2;
        long multiplier1 = 1, multiplier2 = 1;

        while(temp1 != null) {
            num1 += temp1.val * multiplier1;
            multiplier1 *= 10;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            num2 += temp2.val * multiplier2;
            multiplier2 *= 10;
            temp2 = temp2.next;
        }
        
        long sum = num1 + num2;

        if(sum == 0) {
            return new ListNode(0);
        }
        
        ListNode resultDummy = new ListNode();
        ListNode resultTemp = resultDummy;
        
        while(sum > 0) {
            int digit = (int)(sum % 10);
            resultTemp.next = new ListNode(digit);
            resultTemp = resultTemp.next;
            sum /= 10;
        }
        
        return resultDummy.next;
    }
}

public class AddTwoNumbersInLL {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr1[] = {3, 4, 2};  
        int arr2[] = {4, 6, 4};  
        
        ListNode l1 = sol.arrayToLinkedList(arr1);
        ListNode l2 = sol.arrayToLinkedList(arr2);
        
        System.out.print("Optimal - Add Two Numbers: ");
        ListNode result1 = sol.addTwoNumbers(l1, l2);
        sol.displayList(result1);

        // l1 = sol.arrayToLinkedList(arr1);
        // l2 = sol.arrayToLinkedList(arr2);
        
        // System.out.print("Brute - Add Two Numbers: ");
        // ListNode result2 = sol.addTwoNumbersBrute(l1, l2);
        // sol.displayList(result2);
    }
}
