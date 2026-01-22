/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. 
Note that pos is not passed as a parameter.
Do not modify the linked list.
 */

import java.util.HashMap;

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

    int findstartNodeofLoop(Node head){
        
        Node temp = head;
        HashMap<Node,Integer> map = new HashMap<>();
        int i = 1;

        while(temp != null){
            if(map.containsKey(temp)){
                return map.get(temp);
            }

            map.put(temp, i);
            temp = temp.next;
            i++;
        }

        return -1;
    }

    //Optimal Solution - Floyd's Cycle Detection Algorithm
    int findstartNodeofLoopOptimal(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = head;

            int index = 1;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
                index++;
            }
        return index;
    }
}
        return -1;
    }
     
}

public class StartOfLoopLL {
    public static void main(String[] args) {
        Operation op = new Operation();
        int[] arr = {1,2,3,4,5,6};
        Node head = op.arrayToLinkedList(arr);
        //Adding loop for testing
        head.next.next.next.next.next.next = head.next.next; // Creating a loop for testing
        //int startNodeIndex = op.findstartNodeofLoop(head);
        int startNodeIndexOptimal = op.findstartNodeofLoopOptimal(head);
        //System.out.println("Start Node of Loop is at index: " + startNodeIndex);
        System.out.println("Start Node of Loop (Optimal) is at index: " + startNodeIndexOptimal);
    }
}

