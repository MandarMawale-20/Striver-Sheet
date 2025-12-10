class Node{
        Node previous;
        int data;
        Node next;
        
        Node(Node previous, int data, Node next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }

        Node(int data, Node next) {
            this.previous = null;
            this.data = data;
            this.next = next;
        }

        Node(Node previous, int data) {
            this.previous = previous;
            this.data = data;
            this.next = null;
        }

        Node(int data){
            this.previous = null;
            this.data = data;
            this.next = null;
        }

}

class Operation {
    Node arrayToLinkedList(int arr[]){
        if(arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(current, arr[i]);
            current.next = temp;
            current = temp;
        }

        return head;
    }

    void printforwardLL(Node head){
        
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class DoublyLL {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        Operation ops = new Operation();
        Node head = ops.arrayToLinkedList(arr);
        ops.printforwardLL(head);

    }
}
