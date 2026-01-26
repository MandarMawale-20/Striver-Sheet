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

    //Optimal Solution - Merge Sort Approach
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode middle = slow;
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return mergeLL(left, right);

    }

    public ListNode mergeLL(ListNode left, ListNode right) {
        
        ListNode dummy = new ListNode(-1, null);
        ListNode temp = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null) {
            temp.next = left;
        } else {
            temp.next = right;
        }

        return dummy.next;
    }

    //Brute Solution - ArrayList Approach
    public ListNode sortListBrute(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(arr);
        temp = head;
        int i = 0;
        while(temp!=null){
            temp.val = arr.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }
}

public class SortLL {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {4, 2, 1, 3};
        
        ListNode head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal - Sort LL (Merge Sort): ");
        head1 = sol.sortList(head1);
        sol.displayList(head1);

        // ListNode head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute - Sort LL (ArrayList): ");
        // head2 = sol.sortListBrute(head2);
        // sol.displayList(head2);
    }
}

