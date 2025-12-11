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

    public Node InsertatHead(int data,Node head){
        Node temp = new Node(null,data,head);
        if (head != null)
            head.previous = temp;
        return temp;
    }

    public Node InsertatTail(int data,Node head){
        if(head == null) return InsertatHead(data,head);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(temp,data,null);
        temp.next = newNode;

        return head;

    }

    public Node InsertAfter(int data,Node head,int target){
        if(head == null) return head;
        Node temp = head;
        while(temp != null && target != temp.data){
            temp = temp.next;
        }
        if (temp == null) return head;

        Node newNode = new Node(temp, data, temp.next);
        if(temp.next != null)
            temp.next.previous = newNode;
        temp.next = newNode;

        return head;
    }

    public Node insertBefore(int data,Node head,int target){
        if( head == null || head.data == target) return InsertatHead(data, head);
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if(temp == null) return head;
        Node newNode = new Node(temp.previous, data, temp);
        temp.previous.next = newNode;
        temp.previous = newNode;

        return head;
    }

    public Node InsertAtPosition(int data,Node head,int target){
        if(head == null || target<1) return head;

        if(target == 1) return InsertatHead(data,head);
        Node temp = head;
        int count = 1;
        while (temp != null  &&  count < target-1) {
            temp = temp.next;
            count++;
        }
        if(temp == null) return head;
        Node newNode = new Node(temp, data, temp.next);
        if (temp.next != null)
            temp.next.previous = newNode;
        temp.next = newNode;
        return head;
    }

    public Node insertInSortedLL(int data, Node head) {
    if (head == null || data < head.data)
        return InsertatHead(data, head);
    Node temp = head;
    while (temp.next != null && temp.next.data < data) {
        temp = temp.next;
    }
    Node newNode = new Node(temp, data, temp.next);
    if (temp.next != null)
        temp.next.previous = newNode;
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

        Node head = ops.InsertatHead(3,null);
        head = ops.InsertatHead(2,head);
        head = ops.InsertatHead(1,head);

        ops.printforwardLL(head);

        head = ops.InsertatTail(4, head);
        ops.printforwardLL(head);

        head = ops.InsertAtPosition(0, head, 5);
        ops.printforwardLL(head);

        head = ops.InsertAfter(6, head, 4);
        ops.printforwardLL(head);

        head = ops.insertBefore(5, head, 6);
        ops.printforwardLL(head);

        // ops.insertInSortedLL(5, head);
        // ops.printforwardLL(head);
    }
}
