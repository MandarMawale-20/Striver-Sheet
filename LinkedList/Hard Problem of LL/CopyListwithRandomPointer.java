import java.util.*;

/*
 * Problem: Copy List with Random Pointer
 * 
 * A linked list of length n is given such that each node contains an 
 * additional random pointer, which could point to any node in the list, or null.
 * 
 * Construct a deep copy of the list. The deep copy should consist of exactly n 
 * brand new nodes, where each new node has its value set to the value of its 
 * corresponding original node. Both the next and random pointer of the new nodes 
 * should point to new nodes in the copied list such that the pointers in the 
 * original list and copied list represent the same list state.
 * 
 * Example: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
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
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Optimal Solution - Interweave Copy and Separate
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node temp = head;


        while(temp!=null){
            Node fill = new Node(temp.val);
            fill.next = temp.next;
            temp.next = fill;

            temp = temp.next.next;
        }
        
        temp = head;
        while(temp != null){
            if(temp.random == null)
                temp.next.random = temp.random;
            else
                temp.next.random = temp.random.next;

            temp = temp.next.next;
        }

        temp = head;
        Node dummy = head.next;
        Node copyTemp = dummy;

        while (temp != null) {
            temp.next = temp.next.next;
            if (copyTemp.next != null)
                copyTemp.next = copyTemp.next.next;

            temp = temp.next;
            copyTemp = copyTemp.next;
        }

        return dummy;
    }

    //Brute Solution - HashMap Approach
    public Node copyRandomListBrute(Node head) {
        
        if(head == null) return head;
        
        Node temp = head;
        Node dummy = new Node(-1);
        HashMap<Node,Node> map = new HashMap<>();
        Node prev = dummy;

        while(temp != null){
            Node n = new Node(temp.val);
            map.put(temp, n);
            prev.next = n;
            prev = n;
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            Node curr = map.get(temp);
            Node next = map.get(temp.next);
            Node rand = map.get(temp.random);

            curr.next = next;
            curr.random = rand;
            temp = temp.next;
        }

        return dummy.next;
    }
}

public class CopyListwithRandomPointer {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        
        Node head1 = node0;
        
        System.out.print("Optimal - Copy List with Random Pointer: ");
        Node copy1 = sol.copyRandomList(head1);
        sol.displayList(copy1);

        Node node0b = new Node(7);
        Node node1b = new Node(13);
        Node node2b = new Node(11);
        Node node3b = new Node(10);
        Node node4b = new Node(1);
        
        node0b.next = node1b;
        node1b.next = node2b;
        node2b.next = node3b;
        node3b.next = node4b;
        
        node0b.random = null;
        node1b.random = node0b;
        node2b.random = node4b;
        node3b.random = node2b;
        node4b.random = node0b;
        
        Node head2 = node0b;
        
        System.out.print("Brute - Copy List with Random Pointer: ");
        Node copy2 = sol.copyRandomListBrute(head2);
        sol.displayList(copy2);
    }
}
