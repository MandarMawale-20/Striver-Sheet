class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int data1) {
        data = data1;
    }
}

class Operations {

    public Node DeleteHead(Node head) {
        Node temp = head.next;

        return temp;
    }

    public Node Deletetail(Node head) {
        if (head == null)
            return null;

        Node temp = head;
        if (temp.next == null)
            return head = null;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    public Node DeleteParticularElement(Node head, int target) {
        if (head == null)
            return null;
        if (head.data == target)
            return DeleteHead(head);

        Node temp = head;

        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    public Node DeleteAfter(Node head, int target) {
        if (head == null)
            return null;
        Node temp = head;

        while (temp.next != null && temp.data != target) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    public Node DeleteBefore(Node head, int target) {
        if (head == null || target == head.data)
            return null;
        if (head.next.data == target)
            return DeleteHead(head);
        
        Node temp = head;
        Node prevtemp = temp;
        while (temp.next != null && temp.next.data != target) {
            prevtemp = temp;
            temp = temp.next;
        }
        prevtemp.next = temp.next;

        return head;
    }

        public Node DeleteBasedOnIndex(Node head, int index) {
        if (head == null)
            return null;
        if (1 == index)
            return DeleteHead(head);
        Node temp = head;
        
        while (temp.next != null && index-1>1) {
            temp = temp.next;
            index--;
        }

        temp.next = temp.next.next;

        return head;
    }



    public void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DeletionInLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Operations ops = new Operations();
        ops.printList(head);
        head = ops.DeleteHead(head);
        ops.printList(head);

        head = ops.Deletetail(head);
        ops.printList(head);

        head = ops.DeleteParticularElement(head, 2);
        ops.printList(head);

        head = ops.DeleteAfter(head, 2);
        ops.printList(head);
        
        head = ops.DeleteBefore(head, 3);
        ops.printList(head);

        head = ops.DeleteBasedOnIndex(head, 3);
        ops.printList(head);

    }
}
