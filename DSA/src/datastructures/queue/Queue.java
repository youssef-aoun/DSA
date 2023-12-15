package datastructures.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
            length = 1;
            return;
        }
        last.next = newNode;
        last = newNode;
        length++;
    }

    public Node dequeue(){
        if(length == 0){
            return null;
        }
        Node dequeuedNode = first;
        if(length == 1){
            last = null;
            first = null;
            length = 0;
            return dequeuedNode;
        }
        first = first.next;
        dequeuedNode.next = null;
        length--;
        return dequeuedNode;
    }

    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void getFirst() {
        if (first == null) {
            System.out.println("First: null");
        } else {
            System.out.println("First value: " + first.value);
        }
    }

    public void getLast() {
        if (last == null) {
            System.out.println("Last: null");
        } else {
            System.out.println("Last value: " + last.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
}
