package datastructures;

public class LinkedList {

    Node head, tail;
    int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }
        if (head == tail) {
            head = newNode;
            head.next = tail;
            length = 2;
            return;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        length++;
    }

    public void insertAtPosition(int value, int pos) {
        Node newNode = new Node(value);
        if (pos >= length) {
            return;
        }
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            length++;
            return;
        }
        if (pos == length - 1) {
            tail.next = newNode;
            tail = newNode;
            length++;
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node removedNode = head;
        if (head == tail) {
            head = null;
            tail = null;
            length = 0;
            return removedNode;
        }
        head = head.next;
        length--;
        return removedNode;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }
        Node removedNode = head;
        if (head == tail) {
            head = null;
            tail = null;
            length = 0;
            return removedNode;
        }
        while (removedNode.next != tail) {
            removedNode = removedNode.next;
        }
        tail = removedNode;
        removedNode = removedNode.next;
        tail.next = null;
        length--;
        return removedNode;
    }

    public Node removeAtPosition(int pos) {
        if (head == null) {
            return null;
        }
        if (pos >= length) {
            return null;
        }
        Node removedNode = head;
        if (head == tail) {
            head = null;
            tail = null;
            length = 0;
            return removedNode;
        }
        for (int i = 0; i < pos - 1; i++) {
            removedNode = removedNode.next;
        }
        Node temp = removedNode;
        removedNode = removedNode.next;
        temp.next = removedNode.next;
        length--;
        return removedNode;
    }

    public void printList() {
        Node temp = head;
        for (int i = 0; i < length; i++) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public Integer get(int pos) {
        Node temp = head;
        if (pos > length) {
            return null;
        }
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public void set(int value, int pos) {
        Node temp = head;
        if (pos >= length) {
            return;
        }
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        temp.value = value;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp;
        while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
