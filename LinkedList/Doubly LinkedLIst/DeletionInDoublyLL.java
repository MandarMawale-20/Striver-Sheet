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

    Node DeleteHead(Node head) {
        if (head == null || head.next == null)
            return null;
        head = head.next;
        head.previous = null;

        return head;
    }

    Node DeleteTail(Node head) {
         if (head == null || head.next == null)
        return null;
         Node temp = head;
         while (temp.next != null) {
            temp = temp.next;
         }
         temp.previous.next = null;
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

public class DeletionInDoublyLL {
    public static void main(String[] args) {
        Operation ops = new Operation();

        int arr[] = {1,2,3,4,5,6};

        Node head = ops.arrayToDoublyLinkedList(arr);
        ops.printforwardLL(head);
        head = ops.DeleteHead(head);
        ops.printforwardLL(head);

        head = ops.DeleteTail(head);
        ops.printforwardLL(head);
    }
}
