class Node {
    Node previous;
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    Node(Node previous,int data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }
}
class Operation {
    public Node InsertatHead(int data) {
        return InsertatHead(data, null);
    }

    public Node InsertatHead(int data,Node head){
        Node temp = new Node(null,data,head);
        head = temp;
        return head;
    }

    public Node InsertatTail(int data,Node head){
        if(head == null) return InsertatHead(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(temp,data,null);
        temp.next = newNode;

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

public class InsertionInDoublyLL {
    
    public static void main(String[] args) {
        Operation ops = new Operation();

        Node head = ops.InsertatHead(3);
        head = ops.InsertatHead(2,head);
        head = ops.InsertatHead(1,head);

        ops.printforwardLL(head);

        ops.InsertatTail(4, head);
        ops.printforwardLL(head);
    }
}
