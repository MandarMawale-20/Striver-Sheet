

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

    //Optimal Solution - Iterative Reversal in Groups
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while(true){
            ListNode kNode = getKthNode(prev, k);
            if (kNode == null) break;

            ListNode next = kNode.next;

            ListNode back = next;
            ListNode curr = prev.next;

            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = back;
                back = curr;
                curr = temp;
            }

            ListNode temp = prev.next;
            prev.next = kNode;
            prev = temp;
        }

        return dummy.next;
    }

    public ListNode getKthNode(ListNode curr, int k){
        while(curr!=null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }

    //Brute Solution - Recursive Approach
    public ListNode reverseKGroupBrute(ListNode head, int k) {
        
        ListNode curr = head;
        int count = 0;
        
        while(curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        if(count == k) {
            curr = reverseKGroupBrute(curr, k);
            
            while(count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        
        return head;
    }
}

public class ReverseNodeinKNode {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {1, 2, 3, 4, 5};
        int k = 2;
        
        ListNode head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal - Reverse K Group (k=" + k + "): ");
        head1 = sol.reverseKGroup(head1, k);
        sol.displayList(head1);

        // ListNode head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute - Reverse K Group (k=" + k + "): ");
        // head2 = sol.reverseKGroupBrute(head2, k);
        // sol.displayList(head2);
    }
}
