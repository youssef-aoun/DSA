package datastructures.queue;

public class Queue {

    private Node front, back;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        front = newNode;
        back = newNode;
        length = 1;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            front = newNode;
            back = newNode;
            length = 1;
            return;
        }
        back.next = newNode;
        back = newNode;
        length++;
    }

    public Node dequeue(){
        if(length == 0)
            return null;
        Node temp = front;
        if(length == 1){
            front = null;
            back = null;
            length=0;
            return temp;
        }
        front = front.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void getFirst() {
        if (front == null) {
            System.out.println("First: null");
        } else {
            System.out.println("First: " + front.value);
        }
    }

    public void getLast() {
        if (back == null) {
            System.out.println("Last: null");
        } else {
            System.out.println("Last: " + back.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
