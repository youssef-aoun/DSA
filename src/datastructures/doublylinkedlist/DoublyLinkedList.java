package datastructures.doublylinkedlist;

public class DoublyLinkedList {

    private Node head, tail;
    private int length;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length=1;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        length++;
    }

    public Node removeLast(){
        if(head == null)
            return null;
        Node returnedNode = tail;
        if(head == tail) {
            head = null;
            tail = null;
            length = 0;
            return returnedNode;
        }
        tail = tail.prev;
        length--;
        tail.next = null;
        returnedNode.prev = null;
        return returnedNode;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    public Node removeFirst(){
        if(head == null)
            return null;
        Node returnedNode = head;
        if(head == tail){
            head = null;
            tail = null;
            length = 0;
            return returnedNode;
        }
        head = head.next;
        returnedNode.next = null;
        head.prev = null;
        length--;
        return returnedNode;
    }

    public Node get(int index){
        if(index >= length) {
            return null;
        }
        Node temp = head;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        if(index >= length) {
            return false;
        }
        Node temp = head;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index > length) {
            return false;
        }
        Node newNode = new Node(value);
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node temp = head;
        for(int i = 0 ; i < index -1 ; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        temp = temp.next;
        newNode = newNode.next;
        newNode.prev = temp;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index > length || index < 0)
            return null;
        if(index == 0){
            if(length == 0) return null;
            Node temp = head;
            if(length == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
                temp.next = null;
            }
            length--;
            return temp;
        }
        if(index == length){
            if(length == 0) return null;
            Node temp = tail;
            if (length == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
                temp.prev = null;
            }
            length--;
            return temp;
        }
        Node temp = head;
        for(int i = 0 ; i < index -1; i++){
            temp = temp.next;
        }
        Node returnedNode = temp.next;
        temp.next = returnedNode.next;
        temp = returnedNode.next;
        temp.prev = returnedNode.prev;
        returnedNode.next = null;
        returnedNode.prev = null;
        length--;
        return returnedNode;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }


    public boolean isPalindrome(){
        if(length < 2)
            return true;
        Node forward = head;
        Node backward = tail;

        while(forward != null && backward != null){
            if(forward.value != tail.value){
                return false;
            }
            forward = forward.next;
            backward = backward.prev;
        }
        return true;
    }

    class Node{
        int value;
        Node next, prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public void swapPairs(){
        if(length == 0 || length == 1) return;
        Node before = head;
        Node after = head;
        Node holder = before;
        int counter = 0;
        while(after != null){
            after = before.next;
            after.prev = before.prev;
            before.next = after.next;
            before.prev = after;
            after.next = before;
            if(before.next != null){
                before.next.prev = before;
                before = before.next;
            }
            if(counter == 0){
                head = after;
            }
            else{
                after.prev.next = after;}
            counter++;
            after = before.next;
        }
    }
}