package datastructures.linkedlist;


import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    int length;

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public Node removeLast(){
        Node temp = head;
        Node holder = tail;
        if(length == 0)
            return null;
        if(length == 1){
            head = null;
            tail = null;
            length = 0;
            return temp;
        }

        while(temp.next!= tail)
            temp = temp.next;
        temp.next = null;
        tail = temp;
        length--;
        return holder;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
            length = 1;
            return;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeFirst(){
        if(length == 0)
            return null;

        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index){
        Node temp = head;
        if(index >= length || index < 0)
            return null;
        for(int i = 0 ; i < index ; i++)
            temp = temp.next;
        return temp;
    }

    public boolean set(int index, int value){
        if(index >= length || index < 0)
            return false;
        Node temp = head;
        for(int i = 0 ; i < index ; i++)
            temp= temp.next;
        temp.value = value;
        return true;
    }

    public void insert(int index, int value){
        Node newNode = new Node(value);
        if(index > length || index < 0)
            return;
        if(index == 0){
            newNode.next = head;
            head = newNode;
            length++;
            return;
        }
        if(index == length){
            tail.next = newNode;
            tail = newNode;
            length++;
            return;
        }
        Node temp = head;
        for(int i = 0 ; i < index-1 ; i++){
            temp= temp.next;
        }
        Node holder = temp.next;
        temp.next = newNode;
        newNode.next = holder;
        length++;
    }

    public Node remove(int index){
        if(index >= length || index < 0)
            return null;
        Node temp = head;
        if(index == 0){
            head = head.next;
            temp.next = null;
            length--;
            return temp;
        }
        if(index == length-1){
            Node returned = removeLast();
            return returned;
        }
        for(int i = 0 ; i < index-1 ; i++){
            temp = temp.next;
        }
        Node holder = temp.next;
        temp.next = holder.next;
        holder.next = null;
        length--;
        return holder;
    }


    public Node findMiddleNode(){
        if(length == 0) return null;
        if(length == 1){
            return head;
        }
        Node temp = head;
        for(int i = 0 ; i < (length/2) ; i++){
            temp = temp.next;
        }
        return temp;
    }
    public void reverse(){
        Node temp = head;
        if(length <2)
            return;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp;
        while(temp != null){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null value");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public boolean hasLoop(){
        if(head == null) return false;
        if(length==1) return false;
        Node slow = head;
        Node fast = head;
        for(int i = 0 ; i < length ; i++){
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next;
            else{
                return false;
            }
            if(fast.next != null)
                fast = fast.next;
            else{
                return false;
            }
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public Node kthElementEnd(int position){
        Node slow = head;
        Node fast = head;
        for(int i = 0 ; i < position ; i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public void removeDuplicates(){
        Set<Integer> duplicateSet = new HashSet<>();
        if(head == null)
            return;
        if(head.next == null)
            return;
        Node temp = head.next;
        Node behind = head;
        duplicateSet.add(behind.value);
        while(temp != null) {
            int value = temp.value;
            if (duplicateSet.contains(value)) {
                temp = temp.next;
            } else {
                duplicateSet.add(value);
                behind.next = temp;
                behind = behind.next;
                temp = temp.next;
            }
        }
    }

    public void partitionList(int x){
        if(head == null){
            return;
        }
        Node lower = null;
        Node higher = null;
        Node lowerTemp = null;
        Node higherTemp = null;
        Node temp = head;
        int firstLower = 0;
        int firstHigher = 0;
        while(temp != null){
            if(temp.value < x){
                if(firstLower == 0){
                    lower = temp;
                    lowerTemp = lower;
                    firstLower++;
                }
                else{
                    lowerTemp.next = temp;
                    lowerTemp = lowerTemp.next;
                }
            }
            else{
                if(firstHigher == 0){
                    higher = temp;
                    higherTemp = higher;
                    firstHigher++;
                }
                else{
                    higherTemp.next = temp;
                    higherTemp = higherTemp.next;
                }
            }
            temp = temp.next;
        }
        higherTemp.next = null;
        lowerTemp.next = higher;
        head = lower;
    }

    public void reverseBetween(int startIndex, int endIndex){
        if(head == null)
            return;
        if(head.next == null)
            return;
        Node before = head;
        Node after = head;
        for(int i = 0 ; i < startIndex-1 ; i++){
            before = before.next;
        }
        if(endIndex != length) {
            for (int i = 0; i <= endIndex; i++) {
                after = after.next;
            }
        }
        else{
            while(after.next != null){
                after = after.next;
            }
        }
        Node temp = before;
        Node startNode = before;
        Node endNode = before;
        Node prev = null;
        if(startIndex != 0) {
            temp = before.next;
            startNode = startNode.next;
            endNode = endNode.next;
            while (endNode != after) {
                endNode = endNode.next;
                temp.next = prev;
                prev = temp;
                temp = endNode;
            }
            startNode.next = after;
            before.next = prev;
        }
        else{
            while(endNode!= after) {
                endNode = endNode.next;
                temp.next = prev;
                prev = temp;
                temp = endNode;
            }
            before.next = after;
            head = prev;
        }
    }
}