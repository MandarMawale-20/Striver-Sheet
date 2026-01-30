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

    //Optimal Solution - Make Circle and Break
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int count = 1;
        if(head == null || head.next == null )
            return head;

        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        temp.next = head;
        k = k % count;
        int rotate = count - k;
        
        while(rotate > 0){
            temp = temp.next;
            rotate--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
    //Brute Force Solution - Using Extra Space
    public ListNode rotateRightBrute(ListNode head, int k) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        List<Integer> values = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }
        
        int n = values.size();
        k = k % n;
        
        if(k == 0) {
            return head;
        }
        
        List<Integer> rotated = new ArrayList<>();
        for(int i = n - k; i < n; i++) {
            rotated.add(values.get(i));
        }
        for(int i = 0; i < n - k; i++) {
            rotated.add(values.get(i));
        }
        
        ListNode newHead = new ListNode(rotated.get(0));
        ListNode current = newHead;
        for(int i = 1; i < rotated.size(); i++) {
            current.next = new ListNode(rotated.get(i));
            current = current.next;
        }
        
        return newHead;
    }
}

public class RotateList {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {1, 2, 3, 4, 5};
        int k = 2;
        
        ListNode head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal - Rotate Right (k=" + k + "): ");
        head1 = sol.rotateRight(head1, k);
        sol.displayList(head1);

        // ListNode head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute - Rotate Right (k=" + k + "): ");
        // head2 = sol.rotateRightBrute(head2, k);
        // sol.displayList(head2);
    }
}

