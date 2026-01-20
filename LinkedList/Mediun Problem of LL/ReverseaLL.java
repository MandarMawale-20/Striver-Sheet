//Reverse LL (Iterative Approach)

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public Node reverseList(Node head) {
        
        Node prev = null;
        Node temp = head;
        while(temp != null){

            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;

    }
}

public class ReverseaLL {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Node head =  arrayToLinkedList(arr);
        Solution sol = new Solution();
        Node newHead = sol.reverseList(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static Node arrayToLinkedList(int[] arr) {
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }

        return head;

    }
}