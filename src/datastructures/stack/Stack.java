package datastructures.stack;


public class Stack {

    private Node top;
    int height;
    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
            height = 1;
            return;
        }
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop(){
        if(height == 0)
            return null;
        Node returnedNode = top;
        if(height == 1){
            top = null;
            height = 0;
            return returnedNode;
        }
        top = top.next;
        height--;
        return returnedNode;
    }

    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

