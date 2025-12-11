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

    Node DeleteParticularEle(Node head, int target) {
        if (head == null)
            return head;
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }

        if (temp == null)
            return head;

        if (temp == head)
            return DeleteHead(head);
        if (temp.next == null)
            return DeleteTail(head);

        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;

        return head;

    }

    Node DeleteAfter(Node head, int target) {
        if (head == null)
            return head;

        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null)
            return head;

        Node toDelete = temp.next;

        temp.next = toDelete.next;
        if (toDelete.next != null) {
            toDelete.next.previous = temp;
        }

        return head;
    }

    Node DeleteBefore(Node head, int target) {
        if (head == null)
            return head;

        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }

        if (temp == null || temp.previous == null)
            return head;

        Node toDelete = temp.previous;

        if (toDelete == head)
            return DeleteHead(head);

        toDelete.previous.next = temp;
        temp.previous = toDelete.previous;

        return head;
    }

    Node DeleteBasedOnIndex(Node head, int index) {
    if (head == null || index < 0)
        return head;

    if (index == 1)
        return DeleteHead(head);

    Node temp = head;
    int count = 1;
    while (temp != null && count < index) {
        temp = temp.next;
        count++;
    }

    if (temp == null)
        return head;

    if (temp.next == null)
        return DeleteTail(head);

    temp.previous.next = temp.next;
    temp.next.previous = temp.previous;

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

        int arr[] = { 1, 2, 3, 4, 5, 6 };

        Node head = ops.arrayToDoublyLinkedList(arr);
        ops.printforwardLL(head);
        head = ops.DeleteHead(head);
        ops.printforwardLL(head);

        head = ops.DeleteTail(head);
        ops.printforwardLL(head);

        head = ops.DeleteParticularEle(head, 3);
        ops.printforwardLL(head);

        head = ops.DeleteAfter(head, 2);
        ops.printforwardLL(head);

        head = ops.DeleteBefore(head, 5);
        ops.printforwardLL(head);

        head = ops.DeleteBasedOnIndex(head, 2);
        ops.printforwardLL(head);
    }
}
