class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        data = data1;
        next = next1;
    }

    Node(int data1){
        data = data1;
    }
}

class Operations{

    public Node InsertatHead(int data,Node head){
        Node temp = new Node(data,head);
        head  = temp;

        return head;
    }

    public void printList(Node head){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class InsertionInLinkedList {
    
    public static void main(String[] args) {
        
        Node head = new Node(2);
        head.next = new Node(3);

        Operations ops = new Operations();
        ops.printList(head);

        head = ops.InsertatHead(1, head);
        ops.printList(head);

    }
}
