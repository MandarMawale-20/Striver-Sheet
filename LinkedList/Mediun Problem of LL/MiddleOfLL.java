class Node{
    Node next;
    int data;

    Node(int data){
        this.data = data;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

}

class Operation{
    
        Node arrayToLinkedList(int[] arr) {
        if(arr.length == 0 || arr == null) return null;
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }

        return head;
    
    }

    Node findMiddleNode(Node head){

        Node shortjump = head;
        Node longjump = head;

        while(longjump != null && longjump.next != null && shortjump != null){
            longjump = longjump.next.next;
            shortjump = shortjump.next;
        }
        
        return shortjump;
    }
        
}


public class MiddleOfLL{
    public static void main(String[] args) {
        Operation op = new Operation();
        int arr[] = {1,2,3,4,5};
        Node head = op.arrayToLinkedList(arr);
        Node middleNode = op.findMiddleNode(head);
        if(middleNode != null){
            System.out.println("Middle Node data: " + middleNode.data);
        } else {
            System.out.println("The linked list is empty.");
        }
    }
}