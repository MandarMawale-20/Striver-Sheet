class Node {
    Node previous;
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    Node(Node previous, int data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }
}

class Operation {

    Node arrayToDoublyLinkedList(int arr[]) {
        if (arr == null || arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            temp.previous = current;
            current = temp;
        }

        return head;
    }

    Node ReverseTheDoublyLL(Node head) {
        if (head == null)
            return null;

        Node prev = null;
        Node current = head;

        while (current != null) {
            prev = current.previous;
            current.previous = current.next;
            current.next = prev;

            current = current.previous;
        }

        if (prev != null) {
            head = prev.previous;
        }

        return head;
    }

    void printforwardLL(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

}

public class ReverseTheDoublyLL {
    public static void main(String[] args) {
        Operation operation = new Operation();
        
        int arr[] = {1, 2, 3, 4, 5};
        Node head = operation.arrayToDoublyLinkedList(arr);
        
        System.out.print("Original List: ");
        operation.printforwardLL(head);
        
        head = operation.ReverseTheDoublyLL(head);
        
        System.out.print("Reversed List: ");
        operation.printforwardLL(head);
    }
}
