import java.util.*;

class Node {
    int data;
    Node next;
    
    Node() {
        this.data = 0;
        this.next = null;
    }
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class Solution {
    
    Node arrayToLinkedList(int[] arr) {
        if(arr.length == 0 || arr == null) return null;
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }

        return head;
    }

    void displayList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Optimal Solution - Three Pointer Approach
    public Node sortList(Node head) {
        
        Node zero = new Node();
        Node tempzero = zero;
        Node one = new Node();
        Node tempone = one;
        Node two = new Node();
        Node temptwo = two;

        Node temp = head;

        while(temp!=null){
            if(temp.data == 0){
                tempzero.next = temp;
                tempzero = tempzero.next;
            }
            else if(temp.data == 1){
                tempone.next = temp;
                tempone = tempone.next;
            }
            else{
                temptwo.next = temp;
                temptwo = temptwo.next;
            }
            temp = temp.next;
        }
        tempzero.next = one.next;
        tempone.next = two.next;
        temptwo.next = null;

        return zero.next;
    }

    //Brute Solution - Extract, Sort, Reassign
    public Node sortListBrute(Node head) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;

        while(temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(arr);

        temp = head;
        int i = 0;
        while(temp != null) {
            temp.data = arr.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }
}

public class SortLinkedlistOf0s1s2s {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {1, 0, 2, 1, 0, 2};
        
        Node head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal - Sort 0s, 1s, 2s: ");
        head1 = sol.sortList(head1);
        sol.displayList(head1);

        // Node head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute - Sort 0s, 1s, 2s: ");
        // head2 = sol.sortListBrute(head2);
        // sol.displayList(head2);
    }
}
