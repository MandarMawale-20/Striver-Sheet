class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        data = data1;
        next = next1;
    }

    Node(int data1){
        data = data1;
        next = null;
    }
}

public class LinkedList{
    
    public static Node arrayToLinkedList(int[] arr) {
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }

        return head;

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Node head =  arrayToLinkedList(arr);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

    }
}