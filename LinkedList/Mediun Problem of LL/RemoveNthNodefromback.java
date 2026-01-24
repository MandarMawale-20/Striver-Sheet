import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int value) {
        val = value;
        next = null;
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

    //Optimal Solution - Two Pointer Approach
    public ListNode removeNthFromEnd(ListNode head, int N) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    //Brute Solution - Count Length Approach
    public ListNode removeNthFromEndBrute(ListNode head, int N) {
        
        if (head == null) {
            return null;
        }

        int cnt = 0;
        ListNode temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        if (cnt == N) {
            return head.next;
        }

        int res = cnt - N;
        temp = head;

        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}

public class RemoveNthNodefromback {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {1, 2, 3, 4, 5};
        int N = 2;
        
        ListNode head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal - Remove " + N + "th node from end: ");
        head1 = sol.removeNthFromEnd(head1, N);
        sol.displayList(head1);

        // ListNode head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute - Remove " + N + "th node from end: ");
        // head2 = sol.removeNthFromEndBrute(head2, N);
        // sol.displayList(head2);
    }
}
