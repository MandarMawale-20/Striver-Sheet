
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

    void traverseForward(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void traverseBackward(Node head) {
        if (head == null)
            return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.previous;
        }
        System.out.println("null");
    }
}

public class TraversalOfDoublyLL {
    public static void main(String[] args) {
        Operation ops = new Operation();

        int arr[] = { 1, 2, 3, 4, 5, 6 };

        Node head = ops.arrayToDoublyLinkedList(arr);

        System.out.println("Forward Traversal:");
        ops.traverseForward(head);

        System.out.println("Backward Traversal:");
        ops.traverseBackward(head);
    }
}