package datastructures.stack;

public class Stack {
    private Node top;
    private int height;

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void push(int value){
        if(height == 0){
            Node newNode = new Node(value);
            top = newNode;
            height = 1;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop(){
        if(height == 0){
            return null;
        }
        if(height == 1){
            Node poppedNode = top;
            top = null;
            height = 0;
            return poppedNode;
        }
        Node poppedNode = top;
        Node temp = top;
        temp = temp.next;
        top.next = null;
        top = temp;
        height--;
        return poppedNode;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height is: " + height);
    }


    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
