/**
 * Merge Two Sorted Linked Lists
 * 
 * Given two sorted linked lists, merge them into a single sorted linked list.
 * The merged list should be made by splicing together nodes of the two lists.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        return head.next;
    }

    public void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val).append(" -> ");
            temp = temp.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}

public class mergeTwoList {
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result1 = sol.mergeTwoLists(list1, list2);
        System.out.print("Merged: ");
        sol.printList(result1);

    }
}
