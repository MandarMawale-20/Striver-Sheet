class Node {
    int data;
    Node next;

    Node(int data1) {
        data = data1;
    }

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }
}

class Operations {
    public int searchElement(Node head, int target) {
        Node temp = head;
        int pos = 1;

        while (temp != null) {
            if (temp.data == target) {
                return pos;
            }
            temp = temp.next;
            pos++;
        }

        return -1; // target not found
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

public class SearchElement {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Operations ops = new Operations();
        ops.printList(head);
        System.out.println(ops.searchElement(head, 2));
    }

}
