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

    //Optimal Solution - Two Pointer Approach
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        ListNode temp2 = headB;

        while(temp != temp2){
            if(temp == null){
                temp = headB;
            }
            else{
                temp=temp.next;
            }
            
            if(temp2 == null){
                temp2 = headA;
            }
            else{
                temp2 = temp2.next;
            }
        }

        return temp;
    }

    //Better Solution - HashSet Approach
    public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        ListNode temp2 = headB;

        while(temp!=null){
            set.add(temp);
            temp = temp.next;
        }

        while(temp2 != null){
            if(set.contains(temp2)){
                return temp2;
            }
            temp2 = temp2.next;
        }

        return null;
    }

    //Brute Solution - Nested Loop Approach
    public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        
        ListNode temp = headA;

        while(temp != null){
            ListNode temp2 = headB;
            while(temp2 != null){
                if(temp == temp2){
                    return temp;
                }
                temp2 = temp2.next;
            }

            temp = temp.next;
        }

        return null;
    }

    //Helper method to create intersection
    public ListNode[] createIntersection(int[] arr1, int[] arr2, int intersectValue) {
        ListNode headA = arrayToLinkedList(arr1);
        ListNode headB = arrayToLinkedList(arr2);
        
        ListNode tempA = headA;
        while(tempA != null && tempA.val != intersectValue) {
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while(tempB != null && tempB.val != intersectValue) {
            tempB = tempB.next;
        }
        if(tempB != null && tempA != null) {
            tempB.next = tempA;
        }
        
        return new ListNode[]{headA, headB};
    }
}

public class IntersectionOfLL {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr1[] = {4, 1, 8, 4, 5};
        int arr2[] = {5, 6, 1, 8, 4, 5};
        
        ListNode[] lists1 = sol.createIntersection(arr1, arr2, 8);
        ListNode intersection1 = sol.getIntersectionNode(lists1[0], lists1[1]);
        System.out.println("Optimal - Intersection node value: " + (intersection1 != null ? intersection1.val : "null"));

        // ListNode[] lists2 = sol.createIntersection(arr1, arr2, 8);
        // ListNode intersection2 = sol.getIntersectionNodeBetter(lists2[0], lists2[1]);
        // System.out.println("Better - Intersection node value: " + (intersection2 != null ? intersection2.val : "null"));

        // ListNode[] lists3 = sol.createIntersection(arr1, arr2, 8);
        // ListNode intersection3 = sol.getIntersectionNodeBrute(lists3[0], lists3[1]);
        // System.out.println("Brute - Intersection node value: " + (intersection3 != null ? intersection3.val : "null"));
    }
}
