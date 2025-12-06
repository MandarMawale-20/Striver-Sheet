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

    public void InsertTail(int data,Node head){
         Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
    }

    public boolean InsertAfter(int data,int target,Node head){
        Node temp = head;
        while(temp.data != target && temp != null){
            temp = temp.next;
        }
        if(temp == null) return false;
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return true;
    }

    public boolean InsertBefore(int data,int target,Node head){
        Node temp = head;
        Node beforetemp = null;
        while(temp.data != target && temp != null){
            beforetemp = temp;
            temp = temp.next;
        }
        if(temp == null) return false;
        Node newNode = new Node(data);
        newNode.next = beforetemp.next;
        beforetemp.next = newNode;

        return true;
    }

        public boolean InsertAtPos(int data,int target,Node head){
        Node temp = head;
        int count = 1;
        while( count<target-1 && temp != null){
            temp = temp.next;
            count++;
        }
        if(temp == null) return false;
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return true;
    }

    public Node insertInSortedLL(int data,Node head){
        if (head == null || data < head.data) {
            return InsertatHead(data,head);
        }

        Node temp = head;
        while (temp.next != null && temp.next.data < data) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

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

        System.out.println(ops.InsertAfter(2, 2, head));
        ops.printList(head);

        ops.InsertTail(6, head);
        ops.printList(head);

        ops.InsertBefore(9, 2, head);
        ops.printList(head);

        ops.InsertAtPos(4, 3, head);
        ops.printList(head);

        ops.insertInSortedLL(3, head);
        ops.printList(head);
    }
}
