
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
        if(arr == null || arr.length == 0) return null;
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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prevslow = head;
        while(fast != null && fast.next!= null){
            prevslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevslow.next = slow.next;

        return head;
        
    }

    //Brute Solution - Count Length Approach
    public ListNode deleteMiddleBrute(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < (len / 2) - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}

public class DeleteMiddleofLL {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {1, 3, 4, 7, 1, 2, 6};
        
        ListNode head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal - Delete Middle: ");
        head1 = sol.deleteMiddle(head1);
        sol.displayList(head1);

        // ListNode head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute - Delete Middle: ");
        // head2 = sol.deleteMiddleBrute(head2);
        // sol.displayList(head2);
    }
}
