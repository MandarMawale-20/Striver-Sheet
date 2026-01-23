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

    void displayList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Optimal Solution
    public ListNode oddEvenList(ListNode head) {
        
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddcurr = oddHead;
        ListNode evencurr = evenHead;

        boolean even = false;
        ListNode temp = head;
        while(temp!=null){

            if(even){
                evencurr.next = temp;
                evencurr = evencurr.next;
                even = false;
            }
            else{
                oddcurr.next = temp;
                oddcurr = oddcurr.next;
                even = true;
            }

            temp = temp.next;
        }
        
        evencurr.next = null;
        oddcurr.next = evenHead.next;

        return oddHead.next;        
    }

    //Brute Solution
    public ListNode oddEvenListBrute(ListNode head) {
        
        ArrayList<Integer> evenlist = new ArrayList<>();
        ArrayList<Integer> oddlist = new ArrayList<>();
        
        ListNode temp = head;

        boolean even = false;
        while(temp!=null){
            if(even){
                evenlist.add(temp.val);
                even = false;
            }
            else{
                oddlist.add(temp.val);
                even = true;
            }
            temp = temp.next;
        }

        temp = head;
        even = false;
        for(int i = 0;i<oddlist.size();i++){
            temp.val = oddlist.get(i);
            temp=temp.next;
        }
        for(int i = 0;i<evenlist.size();i++){
            temp.val = evenlist.get(i);
            temp=temp.next;
        }

        return head;
    }
}

public class EvenOddLL {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {1, 2, 3, 4, 5};
        
        ListNode head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal: ");
        head1 = sol.oddEvenList(head1);
        sol.displayList(head1);

        // ListNode head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute: ");
        // head2 = sol.oddEvenListBrute(head2);
        // sol.displayList(head2);
    }
}
