
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
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

    //Optimal Solution - Reverse, Add, Reverse
    public Node addOne(Node head) {
        
        Node revhead = reverseLL(head);
        Node temp = revhead;
        Node prev = null;

        boolean carry = true;
        while(temp!=null){
            int data;
            if(carry){
                data = temp.data +1;
            }
            else{
                data = temp.data;
            }
            if(data > 9){
                carry = true;
                data = data%10;
            }
            else{
                carry =false;
            }

            temp.data = data;
            prev = temp;
            temp = temp.next;
        }

        if(carry){
            Node newnode = new Node(1);
            prev.next = newnode;
        }

        return reverseLL(revhead);
    }

    public Node reverseLL(Node head) {
        
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

    //Brute Solution - Using Recursion
    public Node addOneBrute(Node head) {
        int carry = addHelper(head);
        
        if(carry == 1) {
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        
        return head;
    }

    private int addHelper(Node node) {
        if(node == null) {
            return 1;
        }
        
        int carry = addHelper(node.next);
        
        if(carry == 0) {
            return 0;
        }
        
        int sum = node.data + carry;
        node.data = sum % 10;
        return sum / 10;
    }
}

public class Add1ToNumberToLL {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {9, 9, 9};
        
        Node head1 = sol.arrayToLinkedList(arr);
        System.out.print("Optimal - Add 1 to LL: ");
        head1 = sol.addOne(head1);
        sol.displayList(head1);

        // Node head2 = sol.arrayToLinkedList(arr);
        // System.out.print("Brute - Add 1 to LL: ");
        // head2 = sol.addOneBrute(head2);
        // sol.displayList(head2);
    }
}
